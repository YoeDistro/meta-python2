DESCRIPTION = "Platform-independent file locking module"
HOMEPAGE = "http://launchpad.net/pylockfile"
SECTION = "devel/python"

RDEPENDS:${PN} = "python-threading"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2340dffbbfea534b58f1349984eeef72"

inherit pypi setuptools

SRC_URI[md5sum] = "a6a1a82957a23afdf44cfdd039b65ff9"
SRC_URI[sha256sum] = "6aed02de03cba24efabcd600b30540140634fc06cfa603822d508d5361e9f799"

# Satisfy setup.py 'setup_requires'
DEPENDS += " \
        python-pbr-native \
        "


SKIP_RECIPE[python-lockfile] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
