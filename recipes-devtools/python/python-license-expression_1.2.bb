SUMMARY = "Utility library to parse, compare, simplify and normalize license expressions"
HOMEPAGE = "https://github.com/nexB/license-expression"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://apache-2.0.LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"

SRC_URI[md5sum] = "fd4cb295cc345be1071274cdbd81c969"
SRC_URI[sha256sum] = "7960e1dfdf20d127e75ead931476f2b5c7556df05b117a73880b22ade17d1abc"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-booleanpy \
    "

RDEPENDS:${PN}:append:class-target = "\
    ${PYTHON_PN}-logging \
    "

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-license-expression] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
