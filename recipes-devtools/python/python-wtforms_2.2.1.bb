DESCRIPTION = "A flexible forms validation and rendering library for python web development."
HOMEPAGE = "https://pypi.python.org/pypi/WTForms"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=c4660c132770d5d0a5757541f6b79493"

SRC_URI[md5sum] = "41c0008dbe7bd98892c58f7457a46a4a"
SRC_URI[sha256sum] = "0cdbac3e7f6878086c334aa25dc5a33869a3954e9d1e015130d65a69309b3b61"

PYPI_PACKAGE = "WTForms"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-netserver \
    ${PYTHON_PN}-numbers \
    "

inherit pypi setuptools

SKIP_RECIPE[python-wtforms] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
