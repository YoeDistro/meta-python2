SUMMARY = "Backport of the functools module from Python 3.2.3 for use on 2.7 and PyPy."
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=27cf2345969ed18e6730e90fb0063a10"

SRC_URI[md5sum] = "09f24ffd9af9f6cd0f63cb9f4e23d4b2"
SRC_URI[sha256sum] = "f6253dfbe0538ad2e387bd8fdfd9293c925d63553f5813c4e587745416501e6d"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-functools32] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
