SUMMARY = "Text processing system for documentation"
HOMEPAGE = "http://docutils.sourceforge.net"
SECTION = "devel/python"
LICENSE = "PSF-2.0 & BSD-2-Clause & GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=7a4646907ab9083c826280b19e103106"

inherit pypi setuptools

PYPI_PACKAGE = "docutils"

SRC_URI[md5sum] = "e26a308d8000b0bed7416a633217c676"
SRC_URI[sha256sum] = "a2aeea129088da402665e92e0b25b04b073c04b2dce4ab65caaa38b7ce2e1a99"

BBCLASSEXTEND = "native"


SKIP_RECIPE[python-docutils] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
