SUMMARY = "Backport of the selectors module from Python 3.4"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=2fae0222c31d6c10488d4ab93a863af7"

SRC_URI[md5sum] = "bc855a1c8839a811476c019dc07d92dd"
SRC_URI[sha256sum] = "09f5066337f8a76fb5233f267873f89a27a17c10bf79575954894bb71686451c"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-six \
    "    

SKIP_RECIPE[python-selectors34] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
