SUMMARY = "A tiny pythonic visitor implementation."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"

SRC_URI[md5sum] = "94a024ed0ec1b02b4497c15267d319ca"
SRC_URI[sha256sum] = "2c737903b2b6864ebc6167eef7cf3b997126f1aa94bdf590f90f1436d23e480a"

inherit pypi setuptools

SKIP_RECIPE[python-visitor] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
