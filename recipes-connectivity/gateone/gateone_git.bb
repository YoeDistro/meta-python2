SUMMARY = "HTML5 (plugin-free) web-based terminal emulator and SSH client"
LICENSE = "AGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=834cbc6995db88433db17cdf8953a428"
HOMEPAGE = "http://liftoffsoftware.com/Products/GateOne"

PV = "1.2+git${SRCPV}"
SRCREV = "f7a9be46cb90f57459ebd363d24702de0e651034"
SRC_URI = "git://github.com/liftoff/GateOne.git;branch=master;protocol=https \
           file://gateone-avahi.service \
           file://80oe.conf.in \
           file://gateone.service.in \
           file://gateone-init.in \
"

S = "${WORKDIR}/git"

inherit setuptools python-dir systemd update-rc.d

DISTUTILS_INSTALL_ARGS += " \
    --install-data=${PYTHON_SITEPACKAGES_DIR} \
    --install-scripts=${bindir} \
    --skip_init_scripts"

do_install:append() {

    # fix up hardcoded paths
    for file in gateone.service gateone-init 80oe.conf; do
        sed -e s:@bindir@:${bindir}:g \
            -e s:@localstate@:${localstatedir}:g \
            < ${WORKDIR}/$file.in \
            > ${WORKDIR}/$file
    done

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/gateone.service ${D}${systemd_unitdir}/system

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/gateone-init ${D}${sysconfdir}/init.d/gateone

    install -m 0755 -d ${D}${sysconfdir}/avahi/services/
    install -m 0644 ${WORKDIR}/gateone-avahi.service ${D}${sysconfdir}/avahi/services/

    install -m 0755 -d ${D}${sysconfdir}/gateone/conf.d/
    install -m 0644 ${WORKDIR}/80oe.conf ${D}${sysconfdir}/gateone/conf.d/80oe.conf

    install -d ${D}${localstatedir}/lib/gateone
}

FILES:${PN} = "${localstatedir}/lib ${bindir} ${base_libdir} ${sysconfdir} ${PYTHON_SITEPACKAGES_DIR}"
RDEPENDS:${PN} = "mime-support \
                  openssh-ssh \
                  python-compression \
                  python-contextlib \
                  python-crypt \
                  python-datetime \
                  python-email \
                  python-fcntl \
                  python-futures \
                  python-html \
                  python-imaging \
                  python-io \
                  python-json \
                  python-logging \
                  python-misc \
                  python-multiprocessing \
                  python-netclient \
                  python-pkgutil \
                  python-pyopenssl \
                  python-re \
                  python-setuptools \
                  python-shell \
                  python-simplejson \
                  python-subprocess \
                  python-syslog \
                  python-terminal \
                  python-textutils \
                  python-tornado \
                  python-unixadmin \
                  python-xml \
                  python-html5lib \
                  bash \
"

SYSTEMD_SERVICE:${PN} = "gateone.service"
INITSCRIPT_NAME = "gateone"

SKIP_RECIPE[gateone] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
