SUMMARY = "Python Lex and Yacc"
DESCRIPTION = "Python ply: PLY is yet another implementation of lex and yacc for Python"
HOMEPAGE = "https://pypi.python.org/pypi/ply"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://README.md;beginline=5;endline=32;md5=f5ee5c355c0e6719c787a71b8f0fa96c"

SRC_URI[md5sum] = "6465f602e656455affcd7c5734c638f8"
SRC_URI[sha256sum] = "00c7c1aaa88358b9c765b6d3000c6eec0ba42abca5351b095321aef446081da3"

inherit pypi setuptools

RDEPENDS:${PN}:class-target += "\
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-shell \
"

BBCLASSEXTEND = "native"

SKIP_RECIPE[python-ply] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
