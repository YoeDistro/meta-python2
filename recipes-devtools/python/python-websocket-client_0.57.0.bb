SUMMARY = "WebSocket client for python. hybi13 is supported."
HOMEPAGE = "https://github.com/websocket-client/websocket-client.git"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c4c4a98fbc4836b81c8c64d6ecb01fc1"

inherit pypi setuptools

PYPI_PACKAGE = "websocket_client"

SRC_URI[md5sum] = "8061820da5e1de26a6a1a6996d4eebd5"
SRC_URI[sha256sum] = "d735b91d6d1692a6a181f2a8c9e0238e5f6373356f561bb9dc4c7af36f452010"

SKIP_RECIPE[python-websocket-client] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
