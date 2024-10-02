SUMMARY = "Test vectors for the cryptography package."
DESCRIPTION = "cryptography is a package which provides cryptographic recipes \
and primitives to Python developers. Our goal is for it to be your 'cryptographic \
standard library'."
HOMEPAGE = "https://cryptography.io/"
SECTION = "devel/python"

LICENSE = "Apache-2.0 | BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8c3617db4fb6fae01f1d253ab91511e4"

SRC_URI[md5sum] = "a744ed29bb9ef56b3a50317fea3b218e"
SRC_URI[sha256sum] = "6cd32174c56a3eca72f64af43c1daacaae758cfa5ff9d280dfcf818fa11ef116"

DEPENDS += " \
    ${PYTHON_PN}-cryptography \
"


PYPI_PACKAGE = "cryptography_vectors"

UPSTREAM_CHECK_REGEX = ""

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-cryptography-vectors] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
