SUMMARY = "SNMP SMI/MIB Parser"
DESCRIPTION = "A pure-Python implementation of SNMP/SMI MIB \
  parsing and conversion library. Can produce PySNMP MIB modules. \
"
HOMEPAGE = "https://pypi.python.org/pypi/pysmi"
SECTION = "devel/python"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=a088b5c72b59d51a5368ad3b18e219bf"

SRC_URI[md5sum] = "10a9dd140ad512eed9f37344df83ce9d"
SRC_URI[sha256sum] = "bd15a15020aee8376cab5be264c26330824a8b8164ed0195bd402dd59e4e8f7c"

inherit pypi setuptools

RDEPENDS:${PN} = "python-ply"

SKIP_RECIPE[python-pysmi] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
