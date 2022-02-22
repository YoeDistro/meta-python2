SUMMARY = "PyTest Helpers Namespace"
DESCRIPTION = "This plugin does not provide any helpers to pytest, it does, however, provide a helpers namespace in pytest which enables you to register helper functions in your conftest.py to be used within your tests without having to import them."
HOMEPAGE = "https://github.com/saltstack/pytest-helpers-namespace"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=cc99508c43d9d14fd51c7fac622ffd23"

SRC_URI[md5sum] = "04ec1d8750f9b154e782a47cf8b30736"
SRC_URI[sha256sum] = "4eff23a19f92410c0166f6dffbfa8901d3e14a80e97d70cd08428b6d597771ce"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    python-pytest \
    "

SKIP_RECIPE[python-pytest-helpers-namespace] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
