SUMMARY = "PyMongo support for Flask applications"
DESCRIPTION = "PyMongo support for Flask applications."
HOMEPAGE = "https://github.com/mitsuhiko/flask/"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://flask_pymongo/wrappers.py;beginline=1;endline=24;md5=424c4e1047d28e01b4e4634a069c019d"

DEPENDS = "${PYTHON_PN}-vcversioner ${PYTHON_PN}-vcversioner-native"

SRC_URI[md5sum] = "94df71e6800b1d7915cc91a74b70f959"
SRC_URI[sha256sum] = "620eb02dc8808a5fcb90f26cab6cba9d6bf497b15032ae3ca99df80366e33314"

PYPI_PACKAGE = "Flask-PyMongo"

inherit pypi setuptools

RDEPENDS:${PN} = "${PYTHON_PN}-pymongo ${PYTHON_PN}-flask"

SKIP_RECIPE[python-flask-pymongo] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
