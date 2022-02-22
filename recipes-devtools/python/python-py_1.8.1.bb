SUMMARY = "Library with cross-python path, ini-parsing, io, code, log facilities"
HOMEPAGE = "http://py.readthedocs.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a6bb0320b04a0a503f12f69fea479de9"

SRC_URI[md5sum] = "42c67de84b07ac9cc867b8b70843a45b"
SRC_URI[sha256sum] = "5e27081401262157467ad6e7f851b7aa402c5852dbcb3dae06768434de5752aa"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-py] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
