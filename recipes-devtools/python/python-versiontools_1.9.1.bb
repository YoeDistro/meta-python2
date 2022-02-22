SUMMARY = "Smart replacement for plain tuple used in __version__"
SECTION = "devel/python"
HOMEPAGE = "https://launchpad.net/versiontools"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://setup.py;beginline=3;endline=20;md5=02193721a38fd8a05a4ddeb7df8e294d"

inherit pypi setuptools

SRC_URI[md5sum] = "602b7db8eea30dd29a1d451997adf251"
SRC_URI[sha256sum] = "a969332887a18a9c98b0df0ea4d4ca75972f24ca94f06fb87d591377e83414f6"


SKIP_RECIPE[python-versiontools] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
