SUMMARY = "Persistent/Immutable/Functional data structures for Python"
HOMEPAGE = "https://github.com/tobgu/pyrsistent"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE.mit;md5=ca574f2891cf528b3e7a2ee570337e7c"

SRC_URI[md5sum] = "da9486d00ef5b213f40d5cf3c5bca82d"
SRC_URI[sha256sum] = "cdc7b5e3ed77bed61270a47d35434a30617b9becdf2478af76ad2c6ade307280"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-six \
"

RDEPENDS:${PN}:append:class-target = "\
    ${PYTHON_PN}-numbers \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pyrsistent] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
