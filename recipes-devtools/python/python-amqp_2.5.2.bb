DESCRIPTION = "Low-level AMQP client for Python"
HOMEPAGE = "https://pypi.python.org/pypi/amqp/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d6ba772ac59c08a25a12ce15bd5f27b"

SRC_URI[md5sum] = "852ecff645c00f124c78915fcc8ea7c0"
SRC_URI[sha256sum] = "77f1aef9410698d20eaeac5b73a87817365f457a507d82edf292e12cbb83b08d"

PYPI_PACKAGE = "amqp"
inherit setuptools pypi

RDEPENDS:${PN} += " \
	python-vine \
	"

SKIP_RECIPE[python-amqp] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
