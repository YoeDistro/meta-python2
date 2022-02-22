SUMMARY = "Extensions to the standard Python datetime module"
DESCRIPTION = "The dateutil module provides powerful extensions to the \
datetime module available in the Python standard library."
HOMEPAGE = "https://dateutil.readthedocs.org"

LICENSE = "BSD-3-Clause & Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3155c7bdc71f66e02678411d2abf996"

SRC_URI[md5sum] = "f2a1d4b680b297b367a974664ca3a4f6"
SRC_URI[sha256sum] = "73ebfe9dbf22e832286dafa60473e4cd239f8592f699aa5adaf10050e6e1823c"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

PYPI_PACKAGE = "python-dateutil"

inherit pypi setuptools

PACKAGES =+ "${PN}-zoneinfo"
FILES:${PN}-zoneinfo = "${libdir}/${PYTHON_DIR}/site-packages/dateutil/zoneinfo"


RDEPENDS:${PN}:class-target = "\
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-stringold \
"

BBCLASSEXTEND = "native"

SKIP_RECIPE[python-dateutil] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
