
SUMMARY = "Python subprocess replacement"
HOMEPAGE = "https://github.com/amoffat/sh"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=5317094292296f03405f59ae5f6544b6"

SRC_URI[md5sum] = "a8351aef25d25f707c17e0a7a6280251"
SRC_URI[sha256sum] = "b52bf5833ed01c7b5c5fb73a7f71b3d98d48e9b9b8764236237bdc7ecae850fc"

PYPI_PACKAGE = "sh"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-codecs \
    ${PYTHON_PN}-contextlib \
    ${PYTHON_PN}-core \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-lang \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-resource \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-terminal \
    ${PYTHON_PN}-tests \
    ${PYTHON_PN}-textutils \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-unixadmin \
"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    coverage - only used in test and there is a check to see if it is
#               available before importing.
#    queue - part of threading
#    signal - part of core in python3. not sure how it is imported in python2.
#             No complants in compiling.


SKIP_RECIPE[python-sh] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
