SUMMARY = "Fast, pure-Python full text indexing, search, and spell checking library."
DESCRIPTION = "\
Whoosh is a fast, featureful full-text indexing and searching library \
implemented in pure Python. Programmers can use it to easily add search \
functionality to their applications and websites. Every part of how \
Whoosh works can be extended or replaced to meet your needs exactly."
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=05303186defc6141143629961c7c8a60"

SRC_URI[md5sum] = "893433e9c0525ac043df33e6e04caab2"
SRC_URI[sha256sum] = "e0857375f63e9041e03fedd5b7541f97cf78917ac1b6b06c1fcc9b45375dda69"

PYPI_PACKAGE = "Whoosh"
PYPI_PACKAGE_EXT = "zip"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-email \
    ${PYTHON_PN}-multiprocessing \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-pickle \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-stringold \
    ${PYTHON_PN}-subprocess \
"
inherit pypi setuptools


SKIP_RECIPE[python-whoosh] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
