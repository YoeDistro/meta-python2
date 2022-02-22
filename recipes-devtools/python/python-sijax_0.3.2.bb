DESCRIPTION = "An easy to use AJAX library for Python based on jQuery.ajax"
HOMEPAGE = "https://github.com/spantaleev/sijax-python"
LICENSE = "BSD-3-Clause"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=16e213d75641a392478df50cf0841903"

PYPI_PACKAGE = "Sijax"

inherit pypi setuptools

SRC_URI[sha256sum] = "11b062f4a8b2aad95c87e7c09e5daf5a6b0d0f08abf9efe5f91a0075c6be7c0d"


SKIP_RECIPE[python-sijax] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
