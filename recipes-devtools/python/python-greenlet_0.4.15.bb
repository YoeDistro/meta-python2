SUMMARY = "Python lightweight in-process concurrent programming"
LICENSE = "MIT & PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=03143d7a1a9f5d8a0fee825f24ca9c36 \
                    file://LICENSE.PSF;md5=c106931d9429eda0492617f037b8f69a"

SRC_URI[md5sum] = "10fa304f673fc18b28fa6d8c6658cb80"
SRC_URI[sha256sum] = "9416443e219356e3c31f1f918a91badf2e37acf297e2fa13d24d1cc2380f8fbc"

inherit pypi distutils

SKIP_RECIPE[python-greenlet] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
