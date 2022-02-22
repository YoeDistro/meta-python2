SUMMARY = "Strict, simple, lightweight RFC3339 function.s"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8f0e2cd40e05189ec81232da84bd6e1a"

SRC_URI[md5sum] = "4d9b635b4df885bc37bc1189d66c9abc"
SRC_URI[sha256sum] = "5cad17bedfc3af57b399db0fed32771f18fc54bbd917e85546088607ac5e1277"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-strict-rfc3339] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
