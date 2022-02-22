SUMMARY = "Twitter for Python"
DESCRIPTION = "Python module to support twitter API"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=8f702b489acb6863cec8b261a55931d8"

SRC_URI[md5sum] = "8aeff278b7cefcd384c65929bc921e2c"
SRC_URI[sha256sum] = "8abd828ba51a85a2b5bb7373715d6d3bb32d18ac624e3a4db02e4ef8ab48316b"

PYPI_PACKAGE = "tweepy"

inherit pypi setuptools

RDEPENDS:${PN} += "\
        ${PYTHON_PN}-pip \
        ${PYTHON_PN}-pysocks \
        ${PYTHON_PN}-requests \
        ${PYTHON_PN}-six \
        "


SKIP_RECIPE[python-twitter] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
