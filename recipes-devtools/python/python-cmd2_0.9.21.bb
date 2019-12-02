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

SRC_URI[md5sum] = "0e1ce6a2fd8846c2a9e0de2ceb1fa461"
SRC_URI[sha256sum] = "8880fea501bb45a42e8ddde18023d336ccf72f187c4b03e9ee9f13d719ecbd5f"

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
