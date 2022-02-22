SUMMARY  = "Appling JSON patches in Python 2.6+ and 3.x"
HOMEPAGE = "https://github.com/stefankoegl/python-json-patch"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=32b15c843b7a329130f4e266a281ebb3"

SRC_URI[md5sum] = "e86503f05fa192fa870d7004b8ce929a"
SRC_URI[sha256sum] = "cbb72f8bf35260628aea6b508a107245f757d1ec839a19c34349985e2c05645a"

inherit pypi setuptools


RDEPENDS:${PN} += "\
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-jsonpointer \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-re \
    ${PYTHON_PN}-stringold \
"

SKIP_RECIPE[python-jsonpatch] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
