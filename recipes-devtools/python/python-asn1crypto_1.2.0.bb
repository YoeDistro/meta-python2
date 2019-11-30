SUMMARY = "A fast, pure Python library for parsing and serializing ASN.1 structures"
DESCRIPTION = "Fast ASN.1 parser and serializer with definitions for private \
keys, public keys, certificates, CRL, OCSP, CMS, PKCS#3, PKCS#7, PKCS#8, \
PKCS#12, PKCS#5, X.509 and TSP"
HOMEPAGE = "https://github.com/wbond/asn1crypto"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7439e38f5e04ff62fae436184786b7ca"

SRC_URI[md5sum] = "fc3815cdd4812505e3ee297740c5f5d3"
SRC_URI[sha256sum] = "87620880a477123e01177a1f73d0f327210b43a3cdbd714efcd2fa49a8d7b384"

PYPI_PACKAGE = "asn1crypto"

inherit pypi setuptools

RDEPENDS_${PN}_class-target += " \
    ${PYTHON_PN}-codecs \
    ${PYTHON_PN}-crypt \
    ${PYTHON_PN}-ctypes \
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-subprocess \
    ${PYTHON_PN}-textutils \ 
"

BBCLASSEXTEND = "native nativesdk"
