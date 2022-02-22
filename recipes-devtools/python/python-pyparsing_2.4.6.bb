SUMMARY = "Python parsing module"
HOMEPAGE = "http://pyparsing.wikispaces.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=657a566233888513e1f07ba13e2f47f1"

SRC_URI[md5sum] = "29733ea8cbee0291aad121c69c6e51a1"
SRC_URI[sha256sum] = "4c830582a84fb022400b85429791bc551f1f4871c33f23e44f353119e92f969f"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-debugger \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-pprint \
    ${PYTHON_PN}-stringold \
    ${PYTHON_PN}-threading \
"

BBCLASSEXTEND = "native nativesdk"


SKIP_RECIPE[python-pyparsing] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
