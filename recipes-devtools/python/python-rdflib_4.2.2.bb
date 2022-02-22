SUMMARY = "RDFLib is a pure Python package for working with RDF"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=68c1a3bb687bd63b8e5552f3ea249840"

SRC_URI[md5sum] = "534fe35b13c5857d53fa1ac5a41eca67"
SRC_URI[sha256sum] = "da1df14552555c5c7715d8ce71c08f404c988c58a1ecd38552d0da4fc261280d"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-isodate \
    ${PYTHON_PN}-pyparsing \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-rdflib] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
