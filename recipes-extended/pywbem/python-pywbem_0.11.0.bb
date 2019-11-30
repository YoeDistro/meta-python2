
SUMMARY = "Python WBEM Client and Provider Interface"
DESCRIPTION = "\
A Python library for making CIM (Common Information Model) operations over \
HTTP using the WBEM CIM-XML protocol. It is based on the idea that a good \
WBEM client should be easy to use and not necessarily require a large amount \
of programming knowledge. It is suitable for a large range of tasks from \
simply poking around to writing web and GUI applications. \
\
WBEM, or Web Based Enterprise Management is a manageability protocol, like \
SNMP, standardised by the Distributed Management Task Force (DMTF) available \
at http://www.dmtf.org/standards/wbem. \
\
It also provides a Python provider interface, and is the fastest and easiest \
way to write providers on the planet."
HOMEPAGE = "http://pywbem.github.io"
SECTION = "devel/python"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://pywbem/LICENSE.txt;md5=fbc093901857fcd118f065f900982c24"

SRC_URI[md5sum] = "1465dfa92e4cbe558c773838b9b00711"
SRC_URI[sha256sum] = "2a05f2c1a6ab4b08560a6da55fdaabd0f52f4d1e6df6e288b9ed927bf5c289ed"


DEPENDS += " \
    ${PYTHON_PN}-m2crypto-native \
    ${PYTHON_PN}-ply-native \
    ${PYTHON_PN}-pyyaml-native \
    ${PYTHON_PN}-six-native \
    ${PYTHON_PN}-typing-native \
"

inherit pypi setuptools update-alternatives

do_install_append() {
    mv ${D}${bindir}/wbemcli.py ${D}${bindir}/pywbemcli

    rm -f ${D}${bindir}/*.bat
}

RDEPENDS_${PN}_class-target += "\
    ${PYTHON_PN}-argparse \
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-m2crypto \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-ply \
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-stringold \
    ${PYTHON_PN}-subprocess \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-unixadmin \
    ${PYTHON_PN}-xml \
"

ALTERNATIVE_${PN} = "mof_compiler pywbemcli wbemcli"
ALTERNATIVE_TARGET[mof_compiler] = "${bindir}/mof_compiler"
ALTERNATIVE_TARGET[pywbemcli] = "${bindir}/pywbemcli"
ALTERNATIVE_TARGET[wbemcli] = "${bindir}/wbemcli"

ALTERNATIVE_PRIORITY = "30"

BBCLASSEXTEND = "native"
