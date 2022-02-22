DESCRIPTION = "Epydoc is a tool for generating API documentation for Python modules, based on their docstrings"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=011c0d78eb6054d731c879132d7313f0"
HOMEPAGE = "http://epydoc.sourceforge.net/"

SRC_URI[md5sum] = "cdd6f6c76dd8bab5e653a343a0544294"
SRC_URI[sha256sum] = "d4e5c8d90937d01b05170f592c1fa9b29e9ed0498dfe7f0eb2a3af61725b6ad1"

inherit pypi distutils

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-codecs \
    ${PYTHON_PN}-pickle \
    ${PYTHON_PN}-stringold \
    ${PYTHON_PN}-re \
    ${PYTHON_PN}-xml \
    "

BBCLASSEXTEND = "native"

SKIP_RECIPE[python-epydoc] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
