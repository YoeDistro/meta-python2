DESCRIPTION = "A database migration tool for SQLAlchemy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=28aaf14a6592d14dbfb2f4abd597aa27"

SRC_URI[md5sum] = "3d7584a8fb0203ec82b90baa726d2bd9"
SRC_URI[sha256sum] = "3b0cb1948833e062f4048992fbc97ecfaaaac24aaa0d83a1202a99fb58af8c6d"

PYPI_PACKAGE = "alembic"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-dateutil \
    ${PYTHON_PN}-editor \
    ${PYTHON_PN}-mako \
    ${PYTHON_PN}-sqlalchemy \
"
inherit pypi setuptools

SKIP_RECIPE[python-alembic] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
