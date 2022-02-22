DESCRIPTION = "Backport of pathlib-compatible object wrapper for zip files"
HOMEPAGE = "https://github.com/jaraco/zipp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a33f38bbf47d48c70fe0d40e5f77498e"

SRC_URI[md5sum] = "d4451a749d8a7c3c392a9edd1864a937"
SRC_URI[sha256sum] = "3718b1cbcd963c7d4c5511a8240812904164b7f381b647143a89d3b98f9bcd8e"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"
RDEPENDS:${PN} += "${PYTHON_PN}-more-itertools"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-zipp] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
