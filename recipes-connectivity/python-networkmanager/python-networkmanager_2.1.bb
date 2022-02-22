SUMMARY = "Easy communication with NetworkManager from Python"
HOMEPAGE = "https://github.com/seveas/python-networkmanager"
LICENSE = "Zlib"

LIC_FILES_CHKSUM = "file://COPYING;md5=8d8bac174bf8422b151200e6cc78ebe4"

SRC_URI[md5sum] = "f638d854a3639fb37c0e06d1092a771e"
SRC_URI[sha256sum] = "aef1e34d98d7bec7cc368e0ca0f2e97493f9b5ebe6d7103f8f6460cfca3dc6fc"

PYPI_PACKAGE = "python-networkmanager"
inherit pypi setuptools

RDEPENDS:${PN} = "networkmanager python-dbus python-six"

python() {
    if 'networking-layer' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires networking-layer to be present to provide networkmanager.')
}

SKIP_RECIPE[python-networkmanager] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
