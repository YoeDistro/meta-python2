
SUMMARY = "Set of i2c tools for linux - Python module"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://smbusmodule.c;beginline=1;endline=18;md5=46e424fb045901ab25e0f92c28c80055"

SRC_URI = "${KERNELORG_MIRROR}/software/utils/i2c-tools/i2c-tools-${PV}.tar.gz "
SRC_URI[md5sum] = "3536237a6b51fb10caacdc3b8a496237"
SRC_URI[sha256sum] = "ef8f77afc70e7dbfd1171bfeae87a8a7f10074829370ce8d9ccd585a014e0073"

DEPENDS += "i2c-tools"

S = "${WORKDIR}/i2c-tools-${PV}/py-smbus"

inherit distutils

SKIP_RECIPE[python-smbus] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
