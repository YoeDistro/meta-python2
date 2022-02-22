
SUMMARY = "Python TUN/TAP tunnel module"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=13f7629e8e4989b66b4a913ab05a91de"

SRC_URI[md5sum] = "adcaeea56d0ed06814487cdbde32d198"
SRC_URI[sha256sum] = "5ead86b3391acef239535ebcabeb04d2cdc6b40ab14580d28c6da193c2d1fe53"

PYPI_PACKAGE = "python-pytun"

inherit pypi setuptools

SKIP_RECIPE[python-pytun] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
