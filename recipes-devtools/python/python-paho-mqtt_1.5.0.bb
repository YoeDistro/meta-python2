SUMMARY = "MQTT version 3.1/3.1.1 client library"
HOMEPAGE = "http://eclipse.org/paho"
LICENSE = "EPL-1.0 | EDL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=eb48c6ee2cb9f5b8b9fe75e6f817bdfc \
                    file://epl-v10;md5=8d383c379e91d20ba18a52c3e7d3a979 \
                    file://edl-v10;md5=c09f121939f063aeb5235972be8c722c \
"

SRC_URI[md5sum] = "45e80d9b8066a8d0ba1ecfffe271bd3d"
SRC_URI[sha256sum] = "e3d286198baaea195c8b3bc221941d25a3ab0e1507fc1779bdb7473806394be4"

SRCNAME = "paho-mqtt"

inherit pypi setuptools

DEPENDS += "${PYTHON_PN}-pytest-runner-native"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-math \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-subprocess \
    ${PYTHON_PN}-threading \
"

SKIP_RECIPE[python-paho-mqtt] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
