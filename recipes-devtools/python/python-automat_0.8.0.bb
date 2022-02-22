SUMMARY = "Self-service finite-state machines for the programmer on the go"
DESCRIPTION = "Automat is a library for concise, idiomatic Python expression \
of finite-state automata (particularly deterministic finite-state transducers)."
HOMEPAGE = "https://github.com/glyph/Automat"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4ad213bcca81688e94593e5f60c87477"

FILESEXTRAPATHS:prepend := "${THISDIR}/python-automat:"

SRC_URI[md5sum] = "47e980a48201a1dabe37fa11f0187013"
SRC_URI[sha256sum] = "269a09dfb063a3b078983f4976d83f0a0d3e6e7aaf8e27d8df1095e09dc4a484"

SRC_URI:append = " \
    file://0001-setup.py-remove-the-dependency-on-m2r.patch \
"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

PYPI_PACKAGE = "Automat"

inherit pypi setuptools

RDEPENDS:${PN} += "\
   ${PYTHON_PN}-attrs \
   ${PYTHON_PN}-six \
"

SKIP_RECIPE[python-automat] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
