SUMMARY = "A better directory iterator and faster os.walk()"
HOMEPAGE = "https://github.com/benhoyt/scandir"
AUTHOR = "Ben Hoyt"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=482ee62da51806409d432a80eed4e3ea"

SRC_URI = "git://github.com/benhoyt/scandir.git;branch=master;protocol=https"
SRCREV = "982e6ba60e7165ef965567eacd7138149c9ce292"

S = "${WORKDIR}/git"

inherit setuptools

BBCLASSEXTEND = "native nativesdk"
SKIP_RECIPE[python-scandir] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
