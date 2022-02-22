SUMMARY = "Twisted Web Sockets"
HOMEPAGE = "https://github.com/MostAwesomeDude/txWS"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=76699830db7fa9e897f6a1ad05f98ec8"

DEPENDS = "python-twisted python-six python-vcversioner python-six-native python-vcversioner-native"

SRC_URI = "git://github.com/MostAwesomeDude/txWS.git;branch=master;protocol=https"
SRCREV= "88cf6d9b9b685ffa1720644bd53c742afb10a414"

S = "${WORKDIR}/git"

inherit setuptools


SKIP_RECIPE[python-txws] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
