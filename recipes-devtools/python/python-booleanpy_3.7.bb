SUMMARY = "Define boolean algebras, create and parse boolean expressions and create custom boolean DSL"
HOMEPAGE = "https://github.com/bastikr/boolean.py"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e319747a5eb94cddf646037c01ddba47"

SRC_URI += "file://run-ptest"
SRC_URI[md5sum] = "1189d115a38f84f5df743014926a9159"
SRC_URI[sha256sum] = "bd19b412435611ecc712603d0fd7d0e280e24698e7a6e3d5f610473870c5dd1e"

PYPI_PACKAGE = "boolean.py"

inherit pypi setuptools ptest

RDEPENDS:${PN}:append:class-target = "\
    ${PYTHON_PN}-lang \
"

RDEPENDS:${PN}-ptest += "\
    ${PYTHON_PN}-unittest \
    ${PYTHON_PN}-pytest \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/boolean
    cp -rf ${S}/boolean/test_boolean.py  ${D}${PTEST_PATH}/boolean/
}

FILES:${PN}-test = ""

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-booleanpy] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
