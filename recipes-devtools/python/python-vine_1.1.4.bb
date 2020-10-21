DESCRIPTION = "Python promises"
HOMEPAGE = "https://pypi.python.org/pypi/vine"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6fadb0e48ceb84b571372dd706ed76a0"

SRC_URI[md5sum] = "9fdb971e7fd15b181b84f3bfcf20d11c"
SRC_URI[sha256sum] = "52116d59bc45392af9fdd3b75ed98ae48a93e822cee21e5fda249105c59a7a72"

inherit setuptools pypi

RDEPENDS_${PN} += " \
        "
