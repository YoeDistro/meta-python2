SUMMARY = "Cpuset is a Python application to make using the cpusets facilities in the Linux kernel easier"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

S = "${WORKDIR}/git"
SRCREV = "6c46d71a1c6ee711063153b9f7787280128f7252"
SRC_URI = "git://github.com/lpechacek/cpuset.git;protocol=https;;branch=master"

inherit distutils

RDEPENDS:${PN} = "\
    python-core \
    python-re \
    python-logging \
    python-textutils \
    python-unixadmin \
    "

SKIP_RECIPE[python-cpuset] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
