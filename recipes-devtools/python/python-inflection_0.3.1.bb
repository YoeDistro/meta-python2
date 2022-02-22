SUMMARY = "A port of Ruby on Rails' inflection to Python."
HOMEPAGE = "https://pypi.org/project/inflection"
LICENSE = "MIT"
SECTION = "devel/python"
LIC_FILES_CHKSUM = "file://LICENSE;md5=de7833d9c2ce0052a4073928c76a13d7"

SRC_URI[md5sum] = "7941165e9f148e0520023941c0886b40"
SRC_URI[sha256sum] = "18ea7fb7a7d152853386523def08736aa8c32636b047ade55f7578c4edeb16ca"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-codecs \
    ${PYTHON_PN}-pytest \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-inflection] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
