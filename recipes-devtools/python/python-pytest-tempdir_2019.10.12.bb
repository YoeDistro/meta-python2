SUMMARY = "Adds support for a predictable and repeatable temporary directory."
DESCRIPTION = "Adds support for a predictable and repeatable temporary \
directory through the tempdir fixture which gets cleaned up in the end of the \
test run session(this behaviour can be disabled)."
HOMEPAGE = "https://github.com/saltstack/pytest-tempdir"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=9872c3a37cc9baf79a464cd168282be5"

SRC_URI[md5sum] = "79b997d418fb85c2529ab50cd4333689"
SRC_URI[sha256sum] = "e7d91813a9aa991db87dacdef8cfd3f1657632d731d56d06238c5ffb63ab36d8"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    python-pytest \
    "

SKIP_RECIPE[python-pytest-tempdir] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
