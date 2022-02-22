SUMMARY = "Plugin and hook calling mechanisms for python"
HOMEPAGE = "https://github.com/pytest-dev/pluggy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1c8206d16fd5cc02fa9b0bb98955e5c2"

SRC_URI[md5sum] = "7f610e28b8b34487336b585a3dfb803d"
SRC_URI[sha256sum] = "15b2acde666561e1298d71b523007ed7364de07029219b604cf808bfa1c765b0"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"
RDEPENDS:${PN} += "${PYTHON_PN}-importlib-metadata \
                   ${PYTHON_PN}-more-itertools \
"

inherit pypi setuptools

SKIP_RECIPE[python-pluggy] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
