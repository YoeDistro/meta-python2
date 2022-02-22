SUMMARY = "A network address manipulation library for Python."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6345d695ffe3776f68a56fe7962db44"

SRC_URI[md5sum] = "51019ef59c93f3979bcb37d3b8527e07"
SRC_URI[sha256sum] = "38aeec7cdd035081d3a4c306394b19d677623bf76fa0913f6695127c7753aefd"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-pprint \
    ${PYTHON_PN}-textutils \
    ${PYTHON_PN}-xml \
"

SKIP_RECIPE[python-netaddr] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
