
SUMMARY = "A simple connection pool for gevent"
DESCRIPTION = "creates a pool of connections that can be used with gevent"
HOMEPAGE = "https://github.com/studio-ousia/gsocketpool"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4ba825394aec026b5f94edca44426859"
DEPENDS += "${PYTHON_PN}-gevent"
RDEPENDS:${PN} += "${PYTHON_PN}-gevent"

SRC_URI[md5sum] = "49f5f292ef1b60944ae92ca426a5e550"
SRC_URI[sha256sum] = "f2e2749aceadce6b27ca52e2b0a64af99797746a8681e1a2963f72007c14cb14"

inherit pypi setuptools

SKIP_RECIPE[python-gsocketpool] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
