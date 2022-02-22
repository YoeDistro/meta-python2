SUMMARY = "Flask support for XStatic assets"
DESCRIPTION = "Flask is a Python microframework for building websites. \
\
XStatic is a format for packaging static assets. For example, XStatic-jQuery \
is jquery in a form that you can pip install. \
\
This (Flask-XStatic) is a Flask extension that simplifies using XStatic assets \
in your project."
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=659968f6ebd4b70b6c3190d20b4a924c"

SRC_URI[md5sum] = "2f56023e1444c8bd1fec41afe93de743"
SRC_URI[sha256sum] = "226ea8e97065a9488b59bfe5c94af4c6e2ea70a25052e301fb231a1381490133"

FILESEXTRAPATHS:prepend := "${THISDIR}/python-flask-xstatic:"
SRC_URI += "file://remove-pip-requires.patch"

PYPI_PACKAGE = "Flask-XStatic"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-flask \
    ${PYTHON_PN}-xstatic \
    "

SKIP_RECIPE[python-flask-xstatic] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
