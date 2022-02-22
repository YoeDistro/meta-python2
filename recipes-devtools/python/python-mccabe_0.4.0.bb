SUMMARY = "McCabe checker, plugin for flake8"
HOMEPAGE = "https://github.com/dreamhost/cliff"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.rst;md5=f8b50fba1711ecac6bcdb6324f85a66d"

SRC_URI += " \
           file://0001-python-mccabe-remove-unnecessary-setup_requires-pyte.patch \
"

SRC_URI[md5sum] = "8c425db05f310adcd4bb174b991f26f5"
SRC_URI[sha256sum] = "9a2b12ebd876e77c72e41ebf401cc2e7c5b566649d50105ca49822688642207b"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    python-prettytable \
    python-cmd2 \
    python-pyparsing"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-mccabe] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
