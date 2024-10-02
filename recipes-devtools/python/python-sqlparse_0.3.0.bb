
SUMMARY = "Non-validating SQL parser module"
DESCRIPTION = "sqlparse is a non-validating SQL parser module. It provides \
support for parsing, splitting and formatting SQL statements."
HOMEPAGE = "https://github.com/andialbrecht/sqlparse"
SECTION = "devel/python"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2b136f573f5386001ea3b7b9016222fc"

SRC_URI[md5sum] = "2ce34181d6b7b234c9f3c0ecd1ffb93e"
SRC_URI[sha256sum] = "7c3dca29c022744e95b547e867cee89f4fce4373f3549ccd8797d8eb52cdb873"

export BUILD_SYS
export HOST_SYS

inherit pypi setuptools

SKIP_RECIPE[python-sqlparse] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
