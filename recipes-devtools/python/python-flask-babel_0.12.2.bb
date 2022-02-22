SUMMARY = "i18n and l10n support for Flask based on babel and pytz"
DESCRIPTION = "Implements i18n and l10n support for Flask. This is based on \
the Python babel module as well as pytz both of which are installed \
automatically for you if you install this library."
HOMEPAGE = "http://github.com/python-babel/flask-babel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51917f3e8e858f5ae295a7d0e2eb3cc9"

SRC_URI[md5sum] = "fcf2f360ff279d3133e40974804efd72"
SRC_URI[sha256sum] = "316ad183e42003f3922957fa643d0a1e8e34a0f0301a88c3a8f605bc37ba5c86"

PYPI_PACKAGE = "Flask-Babel"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-babel \
    ${PYTHON_PN}-flask \
    ${PYTHON_PN}-speaklater \
    "

SKIP_RECIPE[python-flask-babel] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
