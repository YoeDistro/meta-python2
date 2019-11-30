SUMMARY = "Extra features for standard library's cmd module"
DESCRIPTION = "cmd2 is a tool for building interactive command line \
applications in Python. Its goal is to make it quick and easy for developers \
to build feature-rich and user-friendly interactive command line applications. \
It provides a simple API which is an extension of Python's built-in cmd module.\
 cmd2 provides a wealth of features on top of cmd to make your life easier and \
eliminates much of the boilerplate code which would be necessary when using cmd."
HOMEPAGE = "http://packages.python.org/cmd2/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01aeabea7ae1529a8e4b674b7107d6bc"

SRC_URI[md5sum] = "20f3f76b2aaf36a17372717b469ca969"
SRC_URI[sha256sum] = "c81284083d993af18b8fef57d89d854d49d051d4c2c8a8e12d0281e369ac3682"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

inherit pypi setuptools

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-doctest \
    ${PYTHON_PN}-pyparsing \
    ${PYTHON_PN}-pyperclip \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-stringold \
    ${PYTHON_PN}-subprocess \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-textutils \
    "

BBCLASSEXTEND = "native nativesdk"
