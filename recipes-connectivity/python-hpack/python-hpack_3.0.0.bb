DESCRIPTION = "Pure-Python HPACK header compression"
HOMEPAGE = "https://github.com/python-hyper/hpack"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=5bf1c68e73fbaec2b1687b7e71514393"

SRC_URI[md5sum] = "556b0ae66180f54c2ce8029a0952088b"
SRC_URI[sha256sum] = "8eec9c1f4bfae3408a3f30500261f7e6a65912dc138526ea054f9ad98892e9d2"

inherit pypi setuptools

SKIP_RECIPE[python-hpack] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
