SUMMARY = "Telepathy IM framework - Python package"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1 \
                    file://src/utils.py;beginline=1;endline=17;md5=9a07d1a9791a7429a14e7b25c6c86822"

DEPENDS = "libxslt-native"
RDEPENDS:${PN} += "python-dbus"

SRC_URI = "http://telepathy.freedesktop.org/releases/${BPN}/${BPN}-${PV}.tar.gz \
           file://parallel_make.patch \
           file://remove_duplicate_install.patch \
           file://telepathy-python_fix_for_automake_1.12.patch"

PR = "r6"

inherit autotools pythonnative

SRC_URI[md5sum] = "f7ca25ab3c88874015b7e9728f7f3017"
SRC_URI[sha256sum] = "244c0e1bf4bbd78ae298ea659fe10bf3a73738db550156767cc2477aedf72376"

FILES:${PN} += "\
    ${libdir}/python*/site-packages/telepathy/*.py \
    ${libdir}/python*/site-packages/telepathy/*/*.py \
"

do_install:append () {
    rm -f ${D}${libdir}/python*/site-packages/telepathy/*.pyc
    rm -f ${D}${libdir}/python*/site-packages/telepathy/*.pyo
    rm -f ${D}${libdir}/python*/site-packages/telepathy/*/*.pyc
    rm -f ${D}${libdir}/python*/site-packages/telepathy/*/*.pyo
}

SKIP_RECIPE[telepathy-python] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
