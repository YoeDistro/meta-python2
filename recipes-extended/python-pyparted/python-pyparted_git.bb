SUMMARY = "Python bindings for libparted"
DESCRIPTION = "pyparted is a set of Python modules that provide Python programmers \
an interface to libparted, the GNU parted library for disk partitioning and \
filesystem manipulation."
HOMEPAGE = "https://github.com/rhinstaller/pyparted"
SECTION = "devel/python"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "\
    file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b \
    file://src/_pedmodule.c;beginline=10;endline=22;md5=9e53304db812b80d0939e11bb69dcab2 \
"

# 3.11.4 tag + gcc10 fixes for -fno-common
PV = "3.11.4+git${SRCPV}"

# upstream only publishes releases in github archives which are discouraged
SRCREV = "104ca13567c08c1188b126a395c4602841aae2c6"
SRC_URI = "git://github.com/rhinstaller/pyparted.git;protocol=https;branch=master"

DEPENDS += "parted"

S = "${WORKDIR}/git"

RDEPENDS:${PN}:class-target += " \
    parted (>= 2.3) \
"
RDEPENDS:${PN}:class-native = ""

inherit distutils pkgconfig

RDEPENDS:${PN} += "python-stringold python-codecs python-math python-subprocess"
RDEPENDS:${PN}:class-native = ""

BBCLASSEXTEND = "native"

SKIP_RECIPE[python-pyparted] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
