SUMMARY = "Simple framework for creating REST APIs"
DESCRIPTION = "\
Flask-RESTful is an extension for Flask that adds support for quickly building \
REST APIs"
HOMEPAGE = "https://github.com/flask-restful/flask-restful"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=685bb55ed99a366bb431995f5eef2783"

SRC_URI[md5sum] = "a7217ef1159be38af5faf61aa09aabef"
SRC_URI[sha256sum] = "f8240ec12349afe8df1db168ea7c336c4e5b0271a36982bff7394f93275f2ca9"

inherit pypi setuptools

PYPI_PACKAGE = "Flask-RESTful"

RDEPENDS:${PN} = "${PYTHON_PN}-flask"

SKIP_RECIPE[python-flask-restful] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
