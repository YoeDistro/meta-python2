SUMMARY = "Engine.IO server"
DESCRIPTION = "Python implementation of the Engine.IO realtime client and server."
HOMEPAGE = "https://github.com/miguelgrinberg/python-engineio/"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=42d0a9e728978f0eeb759c3be91536b8"

SRC_URI[md5sum] = "327c16ca05e9b0cc4f994b9d35c7f7d7"
SRC_URI[sha256sum] = "50d108fc7feb7f970e6ebc86733752ebd714545bb5622383e6135bdad45fc9fe"

PYPI_PACKAGE = "python-engineio"

inherit pypi setuptools

RDEPENDS_${PN}_append_class-target = "\
    ${PYTHON_PN}-compression \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-logging \
"

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-six \
"
