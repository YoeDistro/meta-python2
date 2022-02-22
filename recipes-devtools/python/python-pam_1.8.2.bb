DESCRIPTION = "Python PAM module using ctypes, py3/py2."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=64326d42471b493c5c088305364ad5da"

SRC_URI[md5sum] = "db71b6b999246fb05d78ecfbe166629d"
SRC_URI[sha256sum] = "26efe4e79b869b10f97cd8c4a6bbb04a4e54d41186364e975b4108c9c071812c"

PYPI_PACKAGE = "python-pam"

inherit pypi setuptools

RDEPENDS:${PN} = "libpam"

inherit features_check
REQUIRED_DISTRO_FEATURES = "pam"

SKIP_RECIPE[python-pam] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
