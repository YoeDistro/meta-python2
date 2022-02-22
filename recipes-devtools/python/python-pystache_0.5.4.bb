SUMMARY = "Python implementation of Mustache"
HOMEPAGE = "https://github.com/defunkt/pystache"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb4417802c56384aac71b34505528a60"

SRC_URI[md5sum] = "485885e67a0f6411d5252e69b20a35ca"
SRC_URI[sha256sum] = "f7bbc265fb957b4d6c7c042b336563179444ab313fb93a719759111eabd3b85a"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-netserver \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pystache] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
