SUMMARY = "Module for serializing and de-serializing Java objects."
DESCRIPTION = "python-javaobj is a python library that provides functions\
 for reading and writing (writing is WIP currently) Java objects serialized\
 or will be deserialized by ObjectOutputStream. This form of object\
 representation is a standard data interchange format in Java world."
HOMEPAGE = "https://github.com/tcalmant/python-javaobj"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.py;beginline=15;endline=27;md5=af9ce26ac2de1b7436eb08c9308b4a1e"

SRC_URI[md5sum] = "352fe0df9336b8699ad0799ef152da6b"
SRC_URI[sha256sum] = "18c44cfaa214813784a823432b4ab9829c9626b2b00072011627b4008b0067cd"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-enum34 \
    ${PYTHON_PN}-typing \
    "

RDEPENDS:${PN}:append:class-target = "\
    ${PYTHON_PN}-lang \
    ${PYTHON_PN}-logging \
    "

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-javaobj-py3] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
