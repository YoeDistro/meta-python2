
SUMMARY = "A libudev binding"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "cf4d9db7d772622144ca1be6b5d9353b"
SRC_URI[sha256sum] = "094b7a100150114748aaa3b70663485dd360457a709bfaaafe5a977371033f2b"

inherit pypi setuptools

do_configure:prepend() {
    sed -i "/import pyudev/d" ${S}/setup.py
    sed -i "s/str(pyudev.__version__)/'${PV}'/g" ${S}/setup.py
}

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-contextlib \
    ${PYTHON_PN}-ctypes \
    ${PYTHON_PN}-misc \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-subprocess \
    ${PYTHON_PN}-threading \
    libudev \
"


SKIP_RECIPE[python-pyudev] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
