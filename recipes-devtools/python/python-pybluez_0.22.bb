
SUMMARY = "Bluetooth Python extension module"
DESCRIPTION = "Bluetooth Python extension module"
HOMEPAGE = "https://pybluez.readthedocs.io/"
SECTION = "devel/python"

DEPENDS = "bluez5"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=8a71d0475d08eee76d8b6d0c6dbec543"

SRC_URI[md5sum] = "49dab9d5a8f0b798c8125c7f649be3cd"
SRC_URI[sha256sum] = "4ce006716a54d9d18e8186a3f1c8b12a8e6befecffe8fd5828a291fb694ce49d"

S = "${WORKDIR}/PyBluez-${PV}"

PYPI_PACKAGE = "PyBluez"
PYPI_PACKAGE_EXT = "zip"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    bluez5 \
    ${PYTHON_PN}-fcntl \
"

SKIP_RECIPE[python-pybluez] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
