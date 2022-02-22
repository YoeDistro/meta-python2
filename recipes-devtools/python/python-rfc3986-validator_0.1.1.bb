SUMMARY = "Pure python rfc3986 validator"
HOMEPAGE = "https://github.com/naimetti/rfc3986-validator"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a21b13b5a996f08f7e0b088aa38ce9c6"

FILESEXTRAPATHS:prepend := "${THISDIR}/python-rfc3986-validator:"

SRC_URI[md5sum] = "47f7657b790aaf6011a1ab3d86c6be95"
SRC_URI[sha256sum] = "3d44bde7921b3b9ec3ae4e3adca370438eccebc676456449b145d533b240d055"

PYPI_PACKAGE = "rfc3986_validator"

inherit pypi setuptools

SRC_URI:append = " \
    file://0001-setup.py-move-pytest-runner-to-test_requirements.patch \
"

RDEPENDS:${PN} += "\
    python-core \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-rfc3986-validator] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
