DESCRIPTION = "Pamela: yet another Python wrapper for PAM"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=bfb663f37eb99232bc8ccfa4ea8f1202"

SRC_URI[md5sum] = "de6516118d51eb5fc97017f3b6d5c68b"
SRC_URI[sha256sum] = "1e198446a6cdd87704aa0def7621d62e7c20b0e6068e2788b9a866a8355e5d6b"

PYPI_PACKAGE = "pamela"

inherit pypi setuptools

RDEPENDS:${PN} = "libpam"

inherit features_check
REQUIRED_DISTRO_FEATURES = "pam"

# meta-python recipe did not follow Debian naming
PROVIDES += "pamela"

SKIP_RECIPE[python-pamela] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
