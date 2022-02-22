
SUMMARY = "A Python generic test automation framework"
DESCRIPTION = "Generic open source test atomation framework for acceptance\
testing and acceptance test-driven development (ATDD). It has easy-to-use\
tabular test data syntax and it utilizes the keyword-driven testing approach.\
Its testing capabilities can be extended by test libraries implemented either\
with Python or Java, and users can create new higher-level keywords from\
existing ones using the same syntax that is used for creating test cases."
HOMEPAGE = "http://robotframework.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

inherit pypi setuptools

SRC_URI[md5sum] = "ee753415645ff4831ff0d366a0467fe7"
SRC_URI[sha256sum] = "ab94257cbd848dfca7148e092d233a12853cc7e840ce8231af9cbb5e7f51aa47"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-ctypes \
    ${PYTHON_PN}-difflib \
    ${PYTHON_PN}-docutils \
    ${PYTHON_PN}-html \
    ${PYTHON_PN}-pprint \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-xml \
    ${PYTHON_PN}-zlib \
"

SKIP_RECIPE[python-robotframework] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
