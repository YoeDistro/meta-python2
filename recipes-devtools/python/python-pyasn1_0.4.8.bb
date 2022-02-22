
SUMMARY = "Python library implementing ASN.1 types."
HOMEPAGE = "http://pyasn1.sourceforge.net/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=a14482d15c2249de3b6f0e8a47e021fd"

SRC_URI[md5sum] = "dffae4ff9f997a83324b3f33fe62be54"
SRC_URI[sha256sum] = "aef77c9fb94a3ac588e87841208bdec464471d9871bd5050a287cc9a475cd0ba"

inherit pypi setuptools

RDEPENDS:${PN}:class-target += " \
    ${PYTHON_PN}-codecs \
    ${PYTHON_PN}-lang \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-math \
    ${PYTHON_PN}-shell \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pyasn1] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
