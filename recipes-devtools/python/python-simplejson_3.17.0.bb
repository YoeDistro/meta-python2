SUMMARY = "Simple, fast, extensible JSON encoder/decoder for Python"
HOMEPAGE = "http://cheeseshop.python.org/pypi/simplejson"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=c6338d7abd321c0b50a2a547e441c52e"

SRC_URI[md5sum] = "8a5ed75c367b90fedc3d685742e2a1c7"
SRC_URI[sha256sum] = "2b4b2b738b3b99819a17feaf118265d0753d5536049ea570b3c43b51c4701e81"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-netserver \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-re \
"

PACKAGES =+ "${PN}-tests"
RDEPENDS:${PN}-tests = "${PN} ${PYTHON_PN}-unittest"
FILES:${PN}-tests+= " \
    ${PYTHON_SITEPACKAGES_DIR}/simplejson/tests \
    ${PYTHON_SITEPACKAGES_DIR}/simplejson/tool.py* \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-simplejson] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
