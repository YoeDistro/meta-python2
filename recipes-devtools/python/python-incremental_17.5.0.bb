DESCRIPTION = "Incremental is a small library that versions your Python projects"
HOMEPAGE = "https://github.com/twisted/incremental"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6ca9b07f08e2c72d48c74d363d1e0e15"

SRC_URI[md5sum] = "602746e0d438e075a5a9e0678140bba2"
SRC_URI[sha256sum] = "7b751696aaf36eebfab537e458929e194460051ccad279c72b755a167eebd4b3"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-twisted \
    ${PYTHON_PN}-click \
"

# -native is needed to build python[3]-twisted, however, we need to take steps to
# prevent a circular dependency. The build apparently does not use the part of
# python-incremental which uses python-twisted, so this hack is OK.
RDEPENDS:${PYTHON_PN}-incremental-native:remove = "${PYTHON_PN}-twisted-native"
BBCLASSEXTEND = "native"

SKIP_RECIPE[python-incremental] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
