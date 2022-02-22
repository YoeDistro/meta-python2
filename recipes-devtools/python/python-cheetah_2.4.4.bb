SUMMARY = "Python template engine and code generation tool"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aff1107514aa6aae948f9fe71fdc393b"

PR = "r3"

PYPI_PACKAGE = "Cheetah"
inherit pypi setuptools

RDEPENDS:${PN} = "python-pickle python-pprint"
RDEPENDS:${PN}:class-native = ""

BBCLASSEXTEND = "native nativesdk"

SRC_URI[md5sum] = "853917116e731afbc8c8a43c37e6ddba"
SRC_URI[sha256sum] = "be308229f0c1e5e5af4f27d7ee06d90bb19e6af3059794e5fd536a6f29a9b550"

SKIP_RECIPE[python-cheetah] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
