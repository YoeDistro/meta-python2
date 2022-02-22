SUMMARY = "Python LR parsing library"
HOMEPAGE = "http://lrparsing.sourceforge.net/"
BUGTRACKER = "https://sourceforge.net/p/lrparsing/tickets/"
SECTION = "devel/python"
LICENSE = "AGPL-3.0-only"
LIC_FILES_CHKSUM = "file://agpl-3.0.txt;md5=73f1eb20517c55bf9493b7dd6e480788"

SRC_URI = "${SOURCEFORGE_MIRROR}/lrparsing/lrparsing-${PV}.tar.gz"
SRC_URI[md5sum] = "34357d69bce87654d792cd8f02d148b2"
SRC_URI[sha256sum] = "b45afda44001dc5ba632934f74c043d40cce653f1a7526cfbcb68f6be055b8d7"

S = "${WORKDIR}/lrparsing-${PV}"

UPSTREAM_CHECK_URI = "https://sourceforge.net/projects/lrparsing/files/"
UPSTREAM_CHECK_REGEX = "lrparsing-(?P<pver>\d+(\.\d+)+)"

inherit setuptools

BBCLASSEXTEND = "native"

SKIP_RECIPE[python-lrparsing] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
