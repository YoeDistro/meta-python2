SUMMARY = "Controller Area Network (CAN) interface module for Python"
DESCRIPTION = "The Controller Area Network is a bus standard designed to allow \
microcontrollers and devices to communicate with each other. It has priority \
based bus arbitration and reliable deterministic communication. It is used in \
cars, trucks, boats, wheelchairs and more."
HOMEPAGE = "https://github.com/hardbyte/python-can"
SECTION = "devel/python"

LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI[md5sum] = "b724553a330478270267380b4888a18e"
SRC_URI[sha256sum] = "5fefb5c1e7e7f07faefc02c6eac79f9b58376f007048a04d8e7f325d48ec6b2e"

PYPI_PACKAGE="python-can"

inherit pypi setuptools

RDEPENDS:${PN}:class-target += "\
    ${PYTHON_PN}-argparse \
    ${PYTHON_PN}-ctypes \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-misc \
    ${PYTHON_PN}-netserver \
    ${PYTHON_PN}-sqlite3 \
    ${PYTHON_PN}-subprocess \
    ${PYTHON_PN}-wrapt \
    ${PYTHON_PN}-zlib \
"

SKIP_RECIPE[python-can] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
