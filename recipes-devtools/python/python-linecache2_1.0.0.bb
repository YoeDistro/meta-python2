SUMMARY = "A backport of linecache to older supported Pythons"
HOMEPAGE = "https://github.com/testing-cabal/linecache2"
LICENSE = "Python-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=19;endline=19;md5=368ddc8588431c180ae7c33f4fb57519"

DEPENDS = "${PYTHON_PN}-pbr-native"

SRC_URI[md5sum] = "7b25d0289ec36bff1f9e63c4329ce65c"
SRC_URI[sha256sum] = "4b26ff4e7110db76eeb6f5a7b64a82623839d595c2038eeda662f2a2db78e97c"

inherit pypi setuptools

CLEAN_BROKEN = "1"

SKIP_RECIPE[python-linecache2] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
