SUMMARY = "Simple decorator to set attributes of target function or class in a DRY way"
DESCRIPTION = "Simple decorator to set attributes of target function or class in a DRY way"
HOMEPAGE = "https://github.com/denis-ryzhkov/attr"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=59805a0285f4d2b6abdedae73db4f5c1"

SRC_URI[md5sum] = "68b9a503991241fb2df28488686b0e1e"
SRC_URI[sha256sum] = "9091548058d17f132596e61fa7518e504f76b9a4c61ca7d86e1f96dbf7d4775d"

inherit pypi setuptools

SKIP_RECIPE[python-attr] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
