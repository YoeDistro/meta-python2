SUMMARY = "Engine.IO server"
DESCRIPTION = "Python implementation of the Engine.IO realtime client and server."
HOMEPAGE = "https://github.com/miguelgrinberg/python-engineio/"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=42d0a9e728978f0eeb759c3be91536b8"

SRC_URI[md5sum] = "13345452be25c3b63d041f8f89e662d1"
SRC_URI[sha256sum] = "47ae4a9b3b4f2e8a68929f37a518338838e119f24c9a9121af92c49f8bea55c3"

PYPI_PACKAGE = "python-engineio"

inherit pypi setuptools

RDEPENDS:${PN}:append:class-target = "\
    ${PYTHON_PN}-compression \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-logging \
"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-six \
"

SKIP_RECIPE[python-engineio] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
