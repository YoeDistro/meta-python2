SUMMARY = "Python support for YAML"
HOMEPAGE = "http://www.pyyaml.org"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6d8242660a8371add5fe547adf083079"
DEPENDS = "libyaml ${PYTHON_PN}-cython-native ${PYTHON_PN}"

PYPI_PACKAGE = "PyYAML"

inherit pypi setuptools

SRC_URI[md5sum] = "46e25294c7efec23d4072ed6a7777f46"
SRC_URI[sha256sum] = "607774cbba28732bfa802b54baa7484215f530991055bb562efbed5b2f20a45e"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-datetime \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pyyaml] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
