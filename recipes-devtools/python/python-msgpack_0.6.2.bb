SUMMARY = "MessagePack (de)serializer"
HOMEPAGE = "https://msgpack.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=cd9523181d9d4fbf7ffca52eaa2a5751"

SRC_URI[md5sum] = "ba46fdee995565f40e332bd7eea882f1"
SRC_URI[sha256sum] = "ea3c2f859346fcd55fc46e96885301d9c2f7a36d453f5d8f2967840efa1e1830"

PYPI_PACKAGE = "msgpack"

inherit pypi setuptools

RDEPENDS:${PN}:class-target += "\
    ${PYTHON_PN}-io \
"

SKIP_RECIPE[python-msgpack] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
