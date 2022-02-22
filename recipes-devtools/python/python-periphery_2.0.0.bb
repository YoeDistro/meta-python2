
DESCRIPTION = "A pure Python 2/3 library for peripheral I/O (GPIO, LED, PWM, SPI, I2C, MMIO, Serial) in Linux."
HOMEPAGE = "http://pythonhosted.org/python-periphery/"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://PKG-INFO;md5=19f978bd6c8afe3fa9e408b71330512f"

PYPI_PACKAGE = "python-periphery"

inherit pypi setuptools

SRC_URI[sha256sum] = "2df05528a7668db4fb3faaff516b34ed99e9009ed9610a4efe3ea6c0ea8a3aab"

SKIP_RECIPE[python-periphery] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
