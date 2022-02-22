SUMMARY = "Python package for creating and manipulating graphs and networks"
DESCRIPTION = "NetworkX is a Python package for the creation, manipulation, \
and study of the structure, dynamics, and functions of complex networks."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3376ff7c9c58048c62d91431f7f08cde"

SRC_URI[md5sum] = "82608a3686fb3e61f20cf13bfd3c1b4a"
SRC_URI[sha256sum] = "45e56f7ab6fe81652fb4bc9f44faddb0e9025f469f602df14e3b2551c2ea5c8b"

inherit pypi setuptools

PYPI_PACKAGE_EXT = "zip"

RDEPENDS:${PN} += "${PYTHON_PN}-decorator"

SKIP_RECIPE[python-networkx] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
