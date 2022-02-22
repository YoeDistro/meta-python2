DESCRIPTION = "The navigation of Flask application."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=af2ec695dc1f3eb7bd74f79a68a0d789"

SRC_URI[md5sum] = "d1075ee02a3f69da37e5cadad3395f31"
SRC_URI[sha256sum] = "c42d30efa989ca877444a410e8a1cd2563546f9effe3d9fe388eedf7a6c69285"

PYPI_PACKAGE = "Flask-Navigation"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-blinker \
    ${PYTHON_PN}-flask \
    "

SKIP_RECIPE[python-flask-navigation] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
