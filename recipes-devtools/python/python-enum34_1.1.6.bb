SUMMARY = "backport of Python 3.4's enum package"
HOMEPAGE = "https://bitbucket.org/stoneleaf/enum34"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://enum/LICENSE;md5=0a97a53a514564c20efd7b2e8976c87e"

SRC_URI[md5sum] = "5f13a0841a61f7fc295c514490d120d0"
SRC_URI[sha256sum] = "8ad8c4783bf61ded74527bffb48ed9b54166685e4230386a9ed9b1279e2df5b1"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-enum34] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
