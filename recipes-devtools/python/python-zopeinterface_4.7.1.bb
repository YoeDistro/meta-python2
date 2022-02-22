SUMMARY = "Interface definitions for Zope products"
LICENSE = "ZPL-2.1"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e54fd776274c1b7423ec128974bd9d46"

SRC_URI[md5sum] = "1bc66758275c5eb66d169acba3c8e50e"
SRC_URI[sha256sum] = "4bb937e998be9d5e345f486693e477ba79e4344674484001a0b646be1d530487"

PYPI_PACKAGE = "zope.interface"

PACKAGES =. "${PN}-test "

RPROVIDES:${PN} += "zope-interfaces"

RDEPENDS:${PN}:class-target += "${PYTHON_PN}-datetime"

FILES:${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*.egg/*/*/.debug"
FILES:${PN}-dev += "${PYTHON_SITEPACKAGES_DIR}/zope/interface/*.c"
FILES:${PN}-doc += "${PYTHON_SITEPACKAGES_DIR}/zope/interface/*.txt"
FILES:${PN}-test += " \
        ${PYTHON_SITEPACKAGES_DIR}/zope/interface/tests \
        ${PYTHON_SITEPACKAGES_DIR}/zope/interface/common/tests \
"
inherit pypi setuptools

RDEPENDS:${PN}-test += "python-unittest python-doctest"

SKIP_RECIPE[python-zopeinterface] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
