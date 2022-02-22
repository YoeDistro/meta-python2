SUMMARY = "DNSSEC and DLV configuration and priming tool"
DESCRIPTION = "\
DNSSEC configuration and priming tool. Keys are required until the root \
is signed, as well as for local unpublished DNSSEC keys to be preloaded \
into the recursive nameserver. These DNSSEC configuration files can be \
directly included in the bind or unbound nameserver configuration files. \
dnssec-conf includes a commandline configuration client for Bind and \
Unbound, known DNSSEC keys, URL's to official publication pages of keys, \
and harvested keys, as well a script to harvest DNSKEY's from DNS. \
See also: system-config-dnssec"
HOMEPAGE = "https://github.com/xelerance/dnssec-conf"
SECTION = "net"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0636e73ff0215e8d672dc4c32c317bb3"
DEPENDS += "xmlto-native docbook-xml-dtd4-native \
            docbook-xsl-stylesheets-native libxslt-native"

SRC_URI = "git://github.com/xelerance/dnssec-conf.git;branch=master;protocol=https"
SRCREV = "8e799683736b4a7b5e5e78f98fba0a6f48393537"

S = "${WORKDIR}/git"

do_install () {
    rm -rf ${D}
    make PREFIX=${prefix} DESTDIR=${D} ETCDIR=${D}${sysconfdir} install
    # We no longer ship trust anchors. Most of these are in the DLV Registry now.
    # and it prevents the problem of shipping outdated trust anchors.
    # For DLV, we ship the ISC DLV Registry key
    rm -rf ${D}${sysconfdir}/pki/dnssec-keys/harvest/*
    rm -rf ${D}${sysconfdir}/pki/dnssec-keys/production/reverse/*
    install -d -m 0755 ${D}${sysconfdir}/sysconfig
    install -m 0644 packaging/fedora/dnssec.sysconfig ${D}${sysconfdir}/sysconfig/dnssec
}

RDEPENDS:${PN} = "\
    bind-utils \
    curl \
    python \
    python-dnspython \
    python-pyparsing \
"

SKIP_RECIPE[dnssec-conf] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
