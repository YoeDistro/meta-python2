SUMMARY = "Python Atom and RSS feed parser"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c21a7713ef6dc1b99644061c397e7c2a"

SRC_URI[md5sum] = "d552f7a2a55e8e33b2a3fe1082505b42"
SRC_URI[sha256sum] = "bd030652c2d08532c034c27fcd7c85868e7fa3cb2b17f230a44a6bbc92519bf9"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-codecs \
    ${PYTHON_PN}-email \
    ${PYTHON_PN}-html \
    ${PYTHON_PN}-netserver \
    ${PYTHON_PN}-stringold \
    "


SKIP_RECIPE[python-feedparser] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
