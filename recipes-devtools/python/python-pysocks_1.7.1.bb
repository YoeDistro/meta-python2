SUMMARY = "A Python SOCKS client module"
DESCRIPTION = "PySocks lets you send traffic through SOCKS and HTTP proxy \
servers. It is a modern fork of SocksiPy with bug fixes and extra features."
HOMEPAGE = "https://github.com/Anorov/PySocks"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1d457bcffb9661b45f799d4efee72f16"

SRC_URI[md5sum] = "89b1a6865c61bae67a32417517612ee6"
SRC_URI[sha256sum] = "3f8804571ebe159c380ac6de37643bb4685970655d3bba243530d6558b799aa0"

PYPI_PACKAGE = "PySocks"

inherit pypi setuptools

RDEPENDS:${PN}:class-target += "\
    ${PYTHON_PN}-email \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-shell \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pysocks] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
