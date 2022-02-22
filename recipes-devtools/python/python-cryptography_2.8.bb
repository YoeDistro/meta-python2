
SUMMARY = "Provides cryptographic recipes and primitives to python developers"
DESCRIPTION = "cryptography is a package which provides cryptographic recipes \
and primitives to Python developers. Our goal is for it to be your 'cryptographic \
standard library'."
HOMEPAGE = "https://cryptography.io/"
SECTION = "devel/python"

LICENSE = "Apache-2.0 | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=097f805837700cfac572ac274cd38124"

LDSHARED += "-pthread"

DEPENDS += " \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-cffi-native \
    ${PYTHON_PN}-asn1crypto \
    ${PYTHON_PN}-six \
"

SRC_URI[md5sum] = "77730058b556c6d9838679a94c6229ce"
SRC_URI[sha256sum] = "3cda1f0ed8747339bbdf71b9f38ca74c7b592f24f65cdb3ab3765e4b02871651"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-asn1crypto \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-six \
"

RDEPENDS:${PN}:class-target += " \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-asn1crypto \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-threading \
"

RDEPENDS:${PN}-ptest += " \
    ${PN} \
    ${PYTHON_PN}-cryptography-vectors \
    ${PYTHON_PN}-hypothesis \
    ${PYTHON_PN}-iso8601 \
    ${PYTHON_PN}-pretend \
    ${PYTHON_PN}-pytest \
    ${PYTHON_PN}-pytz \
"

inherit ptest

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
    install -d ${D}${PTEST_PATH}/tests/hazmat
    cp -rf ${S}/tests/hazmat/* ${D}${PTEST_PATH}/tests/hazmat/
}

FILES:${PN}-dbg += " \
    ${libdir}/${PYTHON_PN}2.7/site-packages/${SRCNAME}/hazmat/bindings/.debug \
"

SRC_URI += " \
    file://0001-remove-some-more-constants-we-don-t-need-5361.patch \
    file://0002-remove-every-error-we-don-t-use-in-cryptography-or-p.patch \
    file://0003-define-OAEP-properties-for-all-openssl-versions-5589.patch \
    file://run-ptest \
"

DEPENDS += " \
    ${PYTHON_PN}-enum34 \
"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-enum34 \
    ${PYTHON_PN}-ipaddress \
"

RDEPENDS:${PN}:class-target += " \
    ${PYTHON_PN}-enum34 \
    ${PYTHON_PN}-ipaddress \
    ${PYTHON_PN}-contextlib \
    ${PYTHON_PN}-subprocess \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-cryptography] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
