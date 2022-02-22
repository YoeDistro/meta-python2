SUMMARY = "Invoke py.test as distutils command with dependency resolution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a33f38bbf47d48c70fe0d40e5f77498e"

SRC_URI[md5sum] = "e5f66b8e8e87f62c59631c35c919d321"
SRC_URI[sha256sum] = "96c7e73ead7b93e388c5d614770d2bae6526efd997757d3543fe17b557a0942b"

inherit pypi setuptools

DEPENDS += " \
    ${PYTHON_PN}-setuptools-scm-native"

RDEPENDS:${PN} = "${PYTHON_PN}-py ${PYTHON_PN}-setuptools ${PYTHON_PN}-debugger ${PYTHON_PN}-json \
                  ${PYTHON_PN}-io"

# Dependency only exists for python2
RDEPENDS:${PN} += "python-argparse python-compiler"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pytest-runner] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
