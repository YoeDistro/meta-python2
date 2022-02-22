SUMMARY = "HTML parser based on the WHATWG HTML specifcation"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ba5ada9e6fead1fdc32f43c9f10ba7c"

SRC_URI[md5sum] = "942a0688d6bdf20d087c9805c40182ad"
SRC_URI[sha256sum] = "66cb0dcfdbbc4f9c3ba1a63fdb511ffdbd4f513b2b6d81b80cd26ce6b3fb3736"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-lxml \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-webencodings \
    ${PYTHON_PN}-xml \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-html5lib] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
