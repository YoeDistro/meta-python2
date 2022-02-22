SUMMARY = "Python humanize utilities"
HOMEPAGE = "http://github.com/jmoiron/humanize"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE;md5=d2eff82fc25dd07c919a02465884f02e"

SRC_URI[md5sum] = "e8473d9dc1b220911cac2edd53b1d973"
SRC_URI[sha256sum] = "a43f57115831ac7c70de098e6ac46ac13be00d69abbf60bdcac251344785bb19"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-datetime \
"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-humanize] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
