SUMMARY = "PyUSB provides USB access on the Python language"
HOMEPAGE = "http://pyusb.sourceforge.net/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51691ed11cc2c7ae93e383f60ed49b0f"
DEPENDS += "libusb1"

SRC_URI[md5sum] = "862b56452c64948c787ad8ef9498590b"
SRC_URI[sha256sum] = "4e9b72cc4a4205ca64fbf1f3fff39a335512166c151ad103e55c8223ac147362"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"


SKIP_RECIPE[python-pyusb] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
