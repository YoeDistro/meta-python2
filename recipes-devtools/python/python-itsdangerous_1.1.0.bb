SUMMARY = "Various helpers to pass trusted data to untrusted environments and back."
HOMEPAGE = "http://github.com/mitsuhiko/itsdangerous"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=370799bf709a1e4a6a369fa089ac73a6"

SRC_URI[md5sum] = "9b7f5afa7f1e3acfb7786eeca3d99307"
SRC_URI[sha256sum] = "321b033d07f2a4136d3ec762eac9f16a10ccd60f53c0c91af90217ace7ba1f19"

inherit pypi setuptools

CLEANBROKEN = "1"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-simplejson \
    ${PYTHON_PN}-zlib \
"

SKIP_RECIPE[python-itsdangerous] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
