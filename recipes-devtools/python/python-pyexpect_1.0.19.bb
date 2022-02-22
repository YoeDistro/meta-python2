SUMMARY = "Python expectaton library"
DESCRIPTION = "Minimal but very flexible implementation of the expect pattern"
SECTION = "devel/python"
HOMEPAGE = " https://bitbucket.org/dwt/pyexpect"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://README.md;md5=500b884e9dcd5f677a53cbbee8ace939"

inherit pypi setuptools

SRC_URI[md5sum] = "dc744289858001925c75d21e26f1260f"
SRC_URI[sha256sum] = "bff4654b113dac6c2231e486e11dcb23281ddc0742a5404467303fe7638829ef"

SKIP_RECIPE[python-pyexpect] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
