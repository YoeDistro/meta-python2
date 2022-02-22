
SUMMARY = "A drop-in replacement for argparse with options to be set via config files or env variables."
DESCRIPTION = "A drop-in replacement for argparse that allows options to also be set via \
config files and/or environment variables."
HOMEPAGE = "https://github.com/bw2/ConfigArgParse"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da746463714cc35999ed9a42339f2943"

SRC_URI[md5sum] = "aba15b7973b7a70bea86fd69289f8fe3"
SRC_URI[sha256sum] = "baaf0fd2c1c108d007f402dab5481ac5f12d77d034825bf5a27f8224757bd0ac"

PYPI_PACKAGE = "ConfigArgParse"

inherit pypi setuptools

PACKAGECONFIG ?= "yaml"
PACKAGECONFIG[yaml] = ",,,${PYTHON_PN}-pyyaml"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-core \
    ${PYTHON_PN}-shell \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-configargparse] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
