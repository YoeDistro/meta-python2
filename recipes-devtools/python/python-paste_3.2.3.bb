SUMMARY = "Tools for using a Web Server Gateway Interface stack"
HOMEPAGE = "http://pythonpaste.org/"
LICENSE = "MIT"
RDEPENDS:${PN} = "python-six"

LIC_FILES_CHKSUM = "file://docs/license.txt;md5=1798f29d55080c60365e6283cb49779c"

SRC_URI[md5sum] = "7dc6dbd20e358dd95bd42eef5c6cc84c"
SRC_URI[sha256sum] = "8bdc7f6be907eed7cd63868c79d88af2b87d02d840fb5acfc93d4bda572b1567"

PYPI_PACKAGE = "Paste"
inherit pypi setuptools

FILES:${PN} += "/usr/lib/*"

DEPENDS += "${PYTHON_PN}-pytest-runner-native"


SKIP_RECIPE[python-paste] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
