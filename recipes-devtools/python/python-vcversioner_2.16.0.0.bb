SUMMARY = "Python vcversioner, automagically update the project's version"
HOMEPAGE = "https://github.com/habnabit/vcversioner"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=827a7a91a8d20d3c666b665cd96db8e3"

SRC_URI[md5sum] = "aab6ef5e0cf8614a1b1140ed5b7f107d"
SRC_URI[sha256sum] = "dae60c17a479781f44a4010701833f1829140b1eeccd258762a74974aa06e19b"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-subprocess \
    "
RDEPENDS:${PN}:class-native = ""

BBCLASSEXTEND = "native"

SKIP_RECIPE[python-vcversioner] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
