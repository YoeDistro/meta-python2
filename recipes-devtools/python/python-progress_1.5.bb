SUMMARY = "Easy progress reporting for Python"
HOMEPAGE = "http://github.com/verigak/progress/"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aef5566ac4fede9815eccf124c281317"

SRC_URI[md5sum] = "408df0e3db0ad4b74f19f6beec814ae4"
SRC_URI[sha256sum] = "69ecedd1d1bbe71bf6313d88d1e6c4d2957b7f1d4f71312c211257f7dae64372"

inherit pypi setuptools

RDEPENDS:${PN}:class-target += " \
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-math \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-progress] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
