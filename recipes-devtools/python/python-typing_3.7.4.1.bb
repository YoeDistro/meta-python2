SUMMARY = "Simple Python module defined by PEP 484."
HOMEPAGE = "https://github.com/python/typing"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=64fc2b30b67d0a8423c250e0386ed72f"

SRC_URI[md5sum] = "0a1ebd4af65b4769e33459004eb20345"
SRC_URI[sha256sum] = "91dfe6f3f706ee8cc32d38edbbf304e9b7583fb37108fef38229617f8b3eba23"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-typing] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
