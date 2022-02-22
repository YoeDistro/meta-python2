SUMMARY = "Robot Framework test library for serial connection"
HOMEPAGE = "https://github.com/whosaysni/robotframework-seriallibrary"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=7145f7cdd263359b62d342a02f005515"

SRC_URI[md5sum] = "b7c9565d54c30df7cd3f3c0e29adffa3"
SRC_URI[sha256sum] = "256ad60fc0b7df4be44d82c302f5ed8fad4935cda99e4b45942e3c88179d1e19"

PYPI_PACKAGE = "robotframework-seriallibrary"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-pyserial \
    ${PYTHON_PN}-robotframework \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-robotframework-seriallibrary] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
