SUMMARY = "Simple Python module for working with HTML/CSS color definitions."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=197add016087e6884a012b0f185d44ad"

SRC_URI[md5sum] = "40890db38b2a856e526a568864025fe6"
SRC_URI[sha256sum] = "030562f624467a9901f0b455fef05486a88cfb5daa1e356bd4aacea043850b59"

inherit pypi setuptools

RDEPENDS:${PN}:class-target = "\
    ${PYTHON_PN}-stringold \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-webcolors] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
