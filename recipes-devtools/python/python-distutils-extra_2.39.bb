SUMMARY = "python-distutils extension"
DESCRIPTION = "python-distutils extension integrating gettext support, themed icons and scrollkeeper based documentation"
HOMEPAGE = "https://launchpad.net/python-distutils-extra"
SECTION = "devel/python"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4325afd396febcb659c36b49533135d4"

SRC_URI = "https://launchpad.net/python-distutils-extra/trunk/${PV}/+download/python-distutils-extra-${PV}.tar.gz"
SRC_URI[md5sum] = "16e06db0ef73a35b4bff4b9eed5699b5"
SRC_URI[sha256sum] = "723f24f4d65fc8d99b33a002fbbb3771d4cc9d664c97085bf37f3997ae8063af"

inherit setuptools

RDEPENDS:${PN} += "\
    python-distutils \
"

BBCLASSEXTEND = "native"

SKIP_RECIPE[python-distutils-extra] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
