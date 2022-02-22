SUMMARY = "Fast, Extensible Progress Meter"
HOMEPAGE = "http://tqdm.github.io/"
SECTION = "devel/python"

LICENSE = "MIT & MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENCE;md5=054ef7105cba050017d1368262a1623c"

inherit pypi setuptools

SRC_URI[md5sum] = "aa3d5fd173c9fea7408cad14c0e73d5d"
SRC_URI[sha256sum] = "4789ccbb6fc122b5a6a85d512e4e41fc5acad77216533a6f2b8ce51e0f265c23"

RDEPENDS:${PN}:append:class-target = "\
    ${PYTHON_PN}-lang \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-subprocess \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-tqdm] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
