SUMMARY = "collections.abc from Python 3.5"
DESCRIPTION = "A backport of recent additions to the 'collections.abc' module"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dd98d01d471fac8d8dbdd975229dba03"

PYPI_PACKAGE = "backports_abc"

SRC_URI[md5sum] = "7d1936ec183a3586290adf60f6f96764"
SRC_URI[sha256sum] = "033be54514a03e255df75c5aee8f9e672f663f93abb723444caec8fe43437bde"

inherit pypi setuptools

SKIP_RECIPE[python-backports-abc] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
