SUMMARY = "Parsing and validation of URIs (RFC 3986) and IRIs (RFC 3987)"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=9;md5=2b723edf67b2f3088bc5e339b1ceda2d"

SRC_URI[md5sum] = "b6c4028acdc788a9ba697e1c1d6b896c"
SRC_URI[sha256sum] = "d3c4d257a560d544e9826b38bc81db676890c79ab9d7ac92b39c7a253d5ca733"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-rfc3987] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
