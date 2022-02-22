SUMMARY = "A pure Python netlink and Linux network configuration library"
LICENSE = "GPL-2.0-only & Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.GPL.v2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://LICENSE.Apache.v2;md5=34281e312165f843a2b7d1f114fe65ce"

SRC_URI[md5sum] = "371683b62314211b8bc9807ac8ef1144"
SRC_URI[sha256sum] = "963fce07da2841456d39e3b932b071f6de28d23dadfae014022d67a752916f98"

FILESEXTRAPATHS:prepend := "${THISDIR}/python-pyroute2:"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-ctypes \
    ${PYTHON_PN}-distutils \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-multiprocessing \
    ${PYTHON_PN}-pickle \
    ${PYTHON_PN}-pkgutil \
    ${PYTHON_PN}-pprint \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-subprocess \
    ${PYTHON_PN}-unixadmin \
"

SKIP_RECIPE[python-pyroute2] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
