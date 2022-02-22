DESCRIPTION = "Bcrypt hashing for Flask."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0ee2ee5bee7fe96597770e92db5719a8"

SRC_URI[md5sum] = "d345c36ac6637d3ca9fa942e238d00ca"
SRC_URI[sha256sum] = "d71c8585b2ee1c62024392ebdbc447438564e2c8c02b4e57b56a4cafd8d13c5f"

PYPI_PACKAGE = "Flask-Bcrypt"

inherit pypi setuptools

RDEPENDS:${PN} += "${PYTHON_PN}-bcrypt ${PYTHON_PN}-flask"

SKIP_RECIPE[python-flask-bcrypt] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
