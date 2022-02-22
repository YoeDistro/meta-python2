SUMMARY = "Human friendly output for text interfaces using Python"
DESCRIPTION = "Human friendly output for text interfaces using Python"
HOMEPAGE = "https://humanfriendly.readthedocs.io/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=690da298a43805797a4fa7bbe180b3c6"

PYPI_PACKAGE = "humanfriendly"

SRC_URI[md5sum] = "9573f9f37a5454d8205cfd1b9b8db9d2"
SRC_URI[sha256sum] = "33ee8ceb63f1db61cce8b5c800c531e1a61023ac5488ccde2ba574a85be00a85"

inherit pypi setuptools

RDEPENDS:${PN}:class-target += " \
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-fcntl \
    ${PYTHON_PN}-html \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-math \
    ${PYTHON_PN}-multiprocessing \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-stringold \
    ${PYTHON_PN}-unittest \
"

BBCLASSEXTEND = "native"

SKIP_RECIPE[python-humanfriendly] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
