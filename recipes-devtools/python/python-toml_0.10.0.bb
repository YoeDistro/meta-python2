
SUMMARY = "Python Library for Tom's Obvious, Minimal Language"
HOMEPAGE = "https://github.com/uiri/toml"
LICENSE = "MIT"
SECTION = "devel/python"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6d6012eea477117abf51c31262a152f8"

SRC_URI[md5sum] = "63fffbe2d632865ec29cd69bfdf36682"
SRC_URI[sha256sum] = "229f81c57791a41d65e399fc06bf0848bab550a9dfd5ed66df18ce5f05e73d5c"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-datetime \
"

SKIP_RECIPE[python-toml] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
