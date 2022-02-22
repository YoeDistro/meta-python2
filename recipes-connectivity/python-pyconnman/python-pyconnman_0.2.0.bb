
DESCRIPTION = "Python-based Network Connectivity Management"
HOMEPAGE = "https://pypi.python.org/pypi/pyconnman/"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "d60bdffbd9c920f005fdc5e05a8b94cd"
SRC_URI[sha256sum] = "d3a63a039c82b08a1171b003eafa62c6f128aa4eaa1ce7a55a9401b48f9ad926"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    connman \
    python-dbus \
    python-future \
    python-numbers \
    python-pprint \
"

SKIP_RECIPE[python-pyconnman] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
