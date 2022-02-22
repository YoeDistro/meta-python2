SUMMARY = "Python style guide checker"
HOMEPAGE = "https://github.com/dreamhost/cliff"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.rst;md5=d8ebbbe831259ce010179d2f310b0f3e"

SRC_URI[md5sum] = "603821d06db945c71d811b5a8d78423c"
SRC_URI[sha256sum] = "fe249b52e20498e59e0b5c5256aa52ee99fc295b26ec9eaa85776ffdb9fe6374"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    python-prettytable \
    python-cmd2 \
    python-pyparsing"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pep8] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
