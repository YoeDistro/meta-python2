SUMMARY = "Python bindings for the docker credentials store API"
HOMEPAGE = "https://github.com/shin-/dockerpy-creds"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

inherit pypi setuptools

SRC_URI[md5sum] = "322f570cea6b4661c6ac335683988e18"
SRC_URI[sha256sum] = "6ce3270bcaf404cc4c3e27e4b6c70d3521deae82fb508767870fdbf772d584d4"

SKIP_RECIPE[python-docker-pycreds] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
