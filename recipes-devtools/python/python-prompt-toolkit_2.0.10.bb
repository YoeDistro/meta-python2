SUMMARY = "Library for building powerful interactive command lines in Python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2cde7da89f0c1f3e49bf968d00d554f"

SRC_URI[md5sum] = "5016c523e603cd7119644fbc0f00ce53"
SRC_URI[sha256sum] = "f15af68f66e664eaa559d4ac8a928111eebd5feda0c11738b5998045224829db"

PYPI_PACKAGE = "prompt_toolkit"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-core \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-subprocess \
    ${PYTHON_PN}-terminal \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-wcwidth \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-prompt-toolkit] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
