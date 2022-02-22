SUMMARY = "Pyiface is a package that exposes the network interfaces of the operating system in a easy to use and transparent way"
SECTION = "devel/python"
HOMEPAGE = "https://pypi.python.org/pypi/pyiface/"
LICENSE = "GPL-3.0-or-later"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4fe869ee987a340198fb0d54c55c47f1"

SRC_URI[md5sum] = "b066aa984656742738127c9c75436ab4"
SRC_URI[sha256sum] = "e231e5735d329c5b2d4fc8854f069fdaa5436d3ef91ed64ee49e41e3f5e8a3f5"

inherit pypi setuptools

SKIP_RECIPE[python-pyiface] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
