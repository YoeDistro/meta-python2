SUMMARY = "Simple module to parse ISO 8601 dates"
HOMEPAGE = "http://pyiso8601.readthedocs.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b05625f2336fa024e8d57e65c6595844"

SRC_URI[md5sum] = "4de940f691c5ea759fb254384c8ddcf6"
SRC_URI[sha256sum] = "49c4b20e1f38aa5cf109ddcd39647ac419f928512c869dc01d5c7098eddede82"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-datetime \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-iso8601] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
