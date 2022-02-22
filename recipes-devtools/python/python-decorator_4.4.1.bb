SUMMARY = "Python decorator utilities"
DESCRIPTION = "\
The aim of the decorator module it to simplify the usage of decorators \
for the average programmer, and to popularize decorators by showing \
various non-trivial examples. Of course, as all techniques, decorators \
can be abused and you should not try to solve every problem with a \
decorator, just because you can."
HOMEPAGE = "https://github.com/micheles/decorator"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=be2fd2007972bf96c08af3293d728b22"

SRC_URI[md5sum] = "933981f288c4230816b5beee8d40e6ea"
SRC_URI[sha256sum] = "54c38050039232e1db4ad7375cfce6748d7b41c29e95a081c8a6d2c30364a2ce"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-contextlib \
    ${PYTHON_PN}-stringold \
    "

SKIP_RECIPE[python-decorator] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
