DESCRIPTION = "The concurrent.futures module provides a high-level interface for asynchronously executing callables."
SECTION = "devel/python"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=834d982f973c48b6d662b5944c5ab567"
HOMEPAGE = "https://github.com/agronholm/pythonfutures"
DEPENDS = "python"

SRC_URI[md5sum] = "b43a39ae1475e3fd6940f2b4f7214675"
SRC_URI[sha256sum] = "7e033af76a5e35f58e56da7a91e687706faf4e7bdfb2cbc3f2cca6b9bcda9794"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-futures] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
