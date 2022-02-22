SUMMARY = "Migrations for Django"
DESCRIPTION = "South is an intelligent database migrations library for the \
Django web framework. It is database-independent and DVCS-friendly, as well as \
a whole host of other features."
HOMEPAGE = "http://south.aeracode.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=17;endline=18;md5=2155d8ae21e7c23101d5febac696b27e"

SRC_URI[md5sum] = "c76a9758b2011bc3b6c39f881bba2f66"
SRC_URI[sha256sum] = "d360bd31898f9df59f6faa786551065bba45b35e7ee3c39b381b4fbfef7392f4"

PYPI_PACKAGE = "South"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-django \
    "

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-django-south] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
