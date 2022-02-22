SUMMARY = "Seamless operability between C++11 and Python"
HOMEPAGE = "https://github.com/wjakob/pybind11"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=beb87117af69fd10fbf9fb14c22a2e62"

SRC_URI[md5sum] = "23fdca8191b16ce3e7f38fb9e4252b2d"
SRC_URI[sha256sum] = "72e6def53fb491f7f4e92692029d2e7bb5a0783314f20d80222735ff10a75758"

inherit pypi setuptools

SKIP_RECIPE[python-pybind11] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
