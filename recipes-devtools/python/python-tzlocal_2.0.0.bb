SUMMARY = "Library to return tzinfo with the local timezone information"
HOMEPAGE = "https://pypi.org/project/tzlocal/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=57e0bd61643d81d05683cdce65b11d10"

SRC_URI[md5sum] = "b14262cecca16ec9220ca8dff2ca7c5d"
SRC_URI[sha256sum] = "949b9dd5ba4be17190a80c0268167d7e6c92c62b30026cf9764caf3e308e5590"

inherit pypi setuptools

SKIP_RECIPE[python-tzlocal] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
