SUMMARY = "Unified diff parsing/metadata extraction library"
HOMEPAGE = "http://github.com/matiasb/python-unidiff"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4c434b08ef42fea235bb019b5e5a97b3"

SRC_URI[md5sum] = "47f669d7273541fec45e4cc0fba8d8e9"
SRC_URI[sha256sum] = "9c9ab5fb96b6988b4cd5def6b275492442c04a570900d33aa6373105780025bc"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-codecs \
    ${PYTHON_PN}-io \
"

SKIP_RECIPE[python-unidiff] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
