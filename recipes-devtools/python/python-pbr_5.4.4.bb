SUMMARY = "Python Build Reasonableness"
DESCRIPTION = "PBR is a library that injects some useful and sensible default behaviors into your setuptools run"
HOMEPAGE = "https://pypi.python.org/pypi/pbr"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "65cdc32e1a1ff56d481fc15aa8caf988"
SRC_URI[sha256sum] = "139d2625547dbfa5fb0b81daebb39601c478c21956dc57e2e07b74450a8c506b"

inherit pypi setuptools

RDEPENDS:${PN} += "${PYTHON_PN}-pip"

do_install:append() {
        if [ -f ${D}${bindir}/pbr ]; then
                mv ${D}${bindir}/pbr ${D}${bindir}/pbr-2
        fi
}

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pbr] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
