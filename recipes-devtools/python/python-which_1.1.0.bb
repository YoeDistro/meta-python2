DESCRIPTION = "which.py -- a portable GNU which replacement"
HOMEPAGE = "http://code.google.com/p/which/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=030b09798681482b9ad12ac47be496ea"

inherit setuptools pypi python-dir

SRCREV = "425bdeeb2d87c36e2313dc4b8d69ff2bb5a02ee9"
PYPI_SRC_URI = "git://github.com/trentm/which;branch=master;protocol=https"

S = "${WORKDIR}/git"

do_install:append() {
    rmdir -p --ignore-fail-on-non-empty ${D}${STAGING_BINDIR_NATIVE}
    rmdir -p --ignore-fail-on-non-empty ${D}${datadir}
}

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-which] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
