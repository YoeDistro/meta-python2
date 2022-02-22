SUMMARY = "Classes Without Boilerplate"
DESCRIPTION = "attrs is the Python package that will bring back the joy of \
writing classes by relieving you from the drudgery of implementing object \
protocols (aka dunder methods).\
\
Its main goal is to help you to write concise and correct software without \
slowing down your code."
HOMEPAGE = "http://www.attrs.org/"
BUGTRACKER = "https://github.com/python-attrs/attrs/issues"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d4ab25949a73fe7d4fdee93bcbdbf8ff"

SRC_URI[sha256sum] = "f7b7ce16570fe9965acd6d30101a28f62fb4a7f9e926b3bbc9b61f8b04247e72"
SRC_URI[md5sum] = "5b2db50fcc31be34d32798183c9bd062"

inherit pypi setuptools

RDEPENDS:${PN}:class-target += " \
    ${PYTHON_PN}-crypt \
    ${PYTHON_PN}-ctypes \
    ${PYTHON_PN}-subprocess \
"

BBCLASSEXTEND = "native"

SKIP_RECIPE[python-attrs] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
