SUMMARY = "Read metadata from Python packages"
DESCRIPTION = "Read metadata from Python packages"
HOMEPAGE = "https://pypi.org/project/importlib-metadata/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e88ae122f3925d8bde8319060f2ddb8e"

SRC_URI[md5sum] = "80d677d744995336c9c22d21a85ddeb8"
SRC_URI[sha256sum] = "aa18d7378b00b40847790e7c27e11673d7fed219354109d0e7b9e5b25dc3ad26"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

PYPI_PACKAGE = "importlib_metadata"

inherit pypi setuptools

S = "${WORKDIR}/importlib_metadata-${PV}"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-zipp \
    ${PYTHON_PN}-pathlib2 \
    python-compression \
    python-configparser \
    python-contextlib2 \
    python-pathlib2 \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-importlib-metadata] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
