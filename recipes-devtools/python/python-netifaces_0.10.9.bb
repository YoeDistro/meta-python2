SUMMARY = "Portable network interface information for Python"
DESCRIPTION = "Portable network interface information for Python"
HOMEPAGE = "https://github.com/al45tair/netifaces"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=a53cbc7cb75660694e138ba973c148df"

SRC_URI[md5sum] = "de92cc322b4f56047c073f802ad77860"
SRC_URI[sha256sum] = "2dee9ffdd16292878336a58d04a20f0ffe95555465fee7c9bd23b3490ef2abf3"

inherit pypi setuptools

SKIP_RECIPE[python-netifaces] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
