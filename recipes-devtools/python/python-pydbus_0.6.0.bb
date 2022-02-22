SUMMARY = "Pythonic DBus library"
DESCRIPTION = "Pythonic DBus library"
HOMEPAGE = "https://pypi.python.org/pypi/pydbus/"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a916467b91076e631dd8edb7424769c7"

SRC_URI[md5sum] = "c6abd44862322679bd4e907bebc3e0d0"
SRC_URI[sha256sum] = "4207162eff54223822c185da06c1ba8a34137a9602f3da5a528eedf3f78d0f2c"

S = "${WORKDIR}/pydbus-${PV}"

inherit pypi setuptools

RDEPENDS:${PN} = "${PYTHON_PN}-pygobject"

SKIP_RECIPE[python-pydbus] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
