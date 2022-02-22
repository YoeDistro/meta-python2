DESCRIPTION = "HTTP/2 framing layer for Python"
HOMEPAGE = "https://github.com/python-hyper/hyperframe"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=5bf1c68e73fbaec2b1687b7e71514393"

SRC_URI[md5sum] = "6919183242feb26d8bce3b4cba81defd"
SRC_URI[sha256sum] = "a9f5c17f2cc3c719b917c4f33ed1c61bd1f8dfac4b1bd23b7c80b3400971b41f"

inherit pypi setuptools

SKIP_RECIPE[python-hyperframe] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
