SUMMARY = "A library for stubbing in Python"
HOMEPAGE = "https://github.com/alex/pretend"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=411780c0b7fa756753e94affeee5bc99"

SRC_URI[md5sum] = "ad53883ede48aeac7ae584f0de0240e8"
SRC_URI[sha256sum] = "c90eb810cde8ebb06dafcb8796f9a95228ce796531bc806e794c2f4649aa1b10"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pretend] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
