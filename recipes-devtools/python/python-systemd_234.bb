SUMMARY = "Python interface for libsystemd"
HOMEPAGE = "https://github.com/systemd/python-systemd"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4fbd65380cdd255951079008b364516c"

PYPI_PACKAGE = "systemd-python"
DEPENDS += "systemd (<=234)"
RDEPENDS:${PN} += "systemd ${PYTHON_PN}-syslog ${PYTHON_PN}-logging"
REQUIRED_DISTRO_FEATURES = "systemd"

inherit pypi features_check setuptools pkgconfig

SRC_URI[md5sum] = "5071ea5bcb976186e92a3f5e75df221d"
SRC_URI[sha256sum] = "fd0e44bf70eadae45aadc292cb0a7eb5b0b6372cd1b391228047d33895db83e7"

# allow for common patches for python- and python3-systemd
FILESEXTRAPATHS:prepend := "${THISDIR}/python-systemd:"

SRC_URI += "file://endian.patch"

SRC_URI:append:libc-musl = " file://0001-Provide-implementation-of-strndupa-for-musl.patch"

SKIP_RECIPE[python-systemd] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
