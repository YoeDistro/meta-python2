SUMMARY = "User session management for Flask"
DESCRIPTION = "Flask-Login provides user session management for Flask. \
It handles the common tasks of logging in, logging out, and remembering \
your users’ sessions over extended periods of time."
HOMEPAGE = "https://github.com/maxcountryman/flask-login"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8aa87a1cd9fa41d969ad32cfdac2c596"

SRC_URI[md5sum] = "25b34c74bd509792f291c16e184225df"
SRC_URI[sha256sum] = "c815c1ac7b3e35e2081685e389a665f2c74d7e077cb93cecabaea352da4752ec"

PYPI_PACKAGE = "Flask-Login"

inherit pypi setuptools

RDEPENDS:${PN}:class-target = "${PYTHON_PN}-flask"

SKIP_RECIPE[python-flask-login] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
