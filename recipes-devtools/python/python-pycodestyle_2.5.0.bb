
SUMMARY = "Python style guide checker (formly called pep8)"
HOMEPAGE = "https://pypi.org/project/pycodestyle"
LICENSE = "MIT"
SECTION = "devel/python"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01831ddbaf398471da3cc87f5037e822"

SRC_URI[md5sum] = "40e7a76f364a18f531aaba11a4476e21"
SRC_URI[sha256sum] = "e40a936c9a450ad81df37f549d676d127b1b66000a6c500caa2b085bc0ca976c"

inherit pypi setuptools

RDEPENDS:${PN} += "${PYTHON_PN}-lang"

do_install:append () {
        if [ -f ${D}${bindir}/pycodestyle ]; then
                mv ${D}${bindir}/pycodestyle ${D}${bindir}/pycodestyle-2
        fi
}

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pycodestyle] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
