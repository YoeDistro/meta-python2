SUMMARY = "Backports and enhancements for the contextlib module"
DESCRIPTION = "contextlib2 is a backport of the standard library’s contextlib \
module to earlier Python versions."
HOMEPAGE = "http://contextlib2.readthedocs.org/"
SECTION = "devel/python"

LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=43d1c7827e8fad6454b553caf0e1d734"

SRC_URI[md5sum] = "d03a631073b40073b5c41364ad8f5979"
SRC_URI[sha256sum] = "7197aa736777caac513dbd800944c209a49765bf1979b12b037dce0277077ed3"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-contextlib2] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
