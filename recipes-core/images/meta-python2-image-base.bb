SUMMARY = "meta-python2 build test image"

IMAGE_INSTALL = "packagegroup-core-boot"

LICENSE = "MIT"

inherit core-image

PNBLACKLIST[meta-python2-image-base.bb] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
