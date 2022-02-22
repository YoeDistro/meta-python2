SUMMARY = "Parser of the C language, written in pure Python"
HOMEPAGE = "https://github.com/eliben/pycparser"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86f1cedb4e6410a88ce8e30b91079169"

SRC_URI[md5sum] = "76396762adc3fa769c83d8e202d36b6f"
SRC_URI[sha256sum] = "a988718abfad80b6b157acce7bf130a30876d27603738ac39f140993246b25b3"

inherit pypi setuptools

RDEPENDS:${PN}:class-target += "\
    ${PYTHON_PN}-ply \
    ${PYTHON_PN}-pprint \
    ${PYTHON_PN}-subprocess \
    cpp \
    cpp-symlinks \
    "

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pycparser] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
