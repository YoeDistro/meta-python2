SUMMARY = "Internationalised Domain Names in Applications"
HOMEPAGE = "https://github.com/kjd/idna"
LICENSE = "BSD-3-Clause & Python-2.0 & Unicode"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=782775b32f96098512e283fb5d4546cd"

SRC_URI[md5sum] = "2e9ae0b4a0b26d1747c6127cdb060bc1"
SRC_URI[sha256sum] = "c357b3f628cf53ae2c4c05627ecc484553142ca23264e593d327bcde5e9c3407"

inherit pypi setuptools

RDEPENDS:${PN}:class-target = "\
    ${PYTHON_PN}-codecs \
"

# Remove bundled egg-info
do_compile:prepend() {
    rm -rf ${S}/idna.egg-info
}

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-idna] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
