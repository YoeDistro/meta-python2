SUMMARY = "A Python Mocking and Patching Library for Testing"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=de9dfbf780446b18aab11f00baaf5b7e"

SRC_URI[md5sum] = "d834a46d9a129be3e76fdcc99751e82c"
SRC_URI[sha256sum] = "83657d894c90d5681d62155c82bda9c1187827525880eda8ff5df4ec813437c3"

inherit pypi setuptools

DEPENDS += " \
    python-pbr-native"

RDEPENDS:${PN} += " \
    python-prettytable \
    python-cmd2 \
    python-pyparsing \
    python-mccabe \
    python-pep8 \
    python-pyflakes \
    python-pbr \
    python-funcsigs \
"

SKIP_RECIPE[python-mock] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
