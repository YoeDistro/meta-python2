
SUMMARY = "Linux network configuration library for Python"
DESCRIPTION = "This library contains Python bindings to ioctl calls"
SECTION = "devel/python"
HOMEPAGE = "http://github.com/rlisagor/pynetlinux"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=74e1861736ee959824fe7542323c12e9"

inherit pypi setuptools

SRC_URI[md5sum] = "3336e5d4a478acca4e35bf3125b4f883"
SRC_URI[sha256sum] = "4ad08298c9f5ba15a11cddc639ba8778cabdfc402b51066d9e0a325e5a5b391c"

SKIP_RECIPE[python-pynetlinux] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
