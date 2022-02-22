DESCRIPTION = "Media asset management for Python, with glue code for various frameworks"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b810770075a29bf44b96607440e7c801"

SRC_URI[md5sum] = "e8d5dbe36e53d5a35cff227e795e8bbf"
SRC_URI[sha256sum] = "59fea336d0eed38c1f0bf3181ee1222d0ef45f3a9dd34ebe65e6bfffdd6a65a9"

PYPI_PACKAGE = "speaklater"

inherit pypi setuptools

SKIP_RECIPE[python-speaklater] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
