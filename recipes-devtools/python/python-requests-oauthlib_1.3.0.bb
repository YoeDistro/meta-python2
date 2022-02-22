SUMMARY = "OAuthlib authentication support for Requests"
HOMEPAGE = "https://github.com/requests/requests-oauthlib"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=22d117a849df10d047ed9b792838e863"

SRC_URI[md5sum] = "1ebcd55f1b1b9281940b4bc33010e2ba"
SRC_URI[sha256sum] = "b4261601a71fd721a8bd6d7aa1cc1d6a8a93b4a9f5e96626f8e4d91e8beeaa6a"

inherit pypi setuptools

RDEPENDS:${PN} += "${PYTHON_PN}-requests"


SKIP_RECIPE[python-requests-oauthlib] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
