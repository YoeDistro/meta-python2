SUMMARY = "Object-oriented filesystem paths"
DESCRIPTION = "The old pathlib module on bitbucket is in bugfix-only mode. \
The goal of pathlib2 is to provide a backport of standard pathlib module which \
tracks the standard library module, so all the newest features of the standard \
pathlib can be used also on older Python versions."
HOMEPAGE = "https://github.com/mcmtroffaes/pathlib2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=042856c23a3e903b33bf361ea1cbe29a"

SRC_URI[md5sum] = "f2bd0a363eb0f8fa0556f35c1d9e66fb"
SRC_URI[sha256sum] = "6cd9a47b597b37cc57de1c05e56fb1a1c9cc9fab04fe78c29acd090418529868"

inherit pypi setuptools

# Needs python-misc for ntpath
# Could probably be removed by patching out Windows code
RDEPENDS:${PN} += "\
    ${PYTHON_PN}-six \
    python-misc \
    python-scandir \
    python-shell \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pathlib2] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
