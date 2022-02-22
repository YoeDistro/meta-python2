SUMMARY = "Core utilities for Python packages"
DESCRIPTION = "The packaging project includes the following: version handling, \
specifiers, markers, requirements, tags, utilities."
HOMEPAGE = "https://github.com/pypa/packaging"
LICENSE = "Apache-2.0 & BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=faadaedca9251a90b205c9167578ce91"

SRC_URI[md5sum] = "93d6ccbdfcb5b7697b6ecea53ecc294b"
SRC_URI[sha256sum] = "fe1d8331dfa7cc0a883b49d75fc76380b2ab2734b220fbb87d774e4fd4b851f8"

inherit pypi setuptools

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS:${PN} += "${PYTHON_PN}-six ${PYTHON_PN}-pyparsing"

SKIP_RECIPE[python-packaging] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
