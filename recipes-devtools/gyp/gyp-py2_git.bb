DESCRIPTION = "GYP is a Meta-Build system: a build system that generates other build systems."
HOMEPAGE = "https://gyp.gsrc.io/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ab828cb8ce4c62ee82945a11247b6bbd"
SECTION = "devel"

SRC_URI = "git://chromium.googlesource.com/external/gyp;protocol=https;branch=master"
SRCREV = "fcd686f1880fa52a1ee78d3e98af1b88cb334528"

S = "${WORKDIR}/git"
PV = "0.1+git${SRCPV}"

BBCLASSEXTEND = "native nativesdk"
inherit setuptools

SKIP_RECIPE[gyp-py2] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
