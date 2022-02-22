SUMMARY = "Scripting support for flask"
DESCRIPTION = "Flask support for writing external scripts."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e686048adb69341fc8a08caeda528b41"

SRC_URI[md5sum] = "3fbd91fe13cebedfb2431331f6eabb68"
SRC_URI[sha256sum] = "6425963d91054cfcc185807141c7314a9c5ad46325911bd24dcb489bd0161c65"

PYPI_PACKAGE = "Flask-Script"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-flask \
    "

SKIP_RECIPE[python-flask-script] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
