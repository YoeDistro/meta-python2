SUMMARY = "Library for rapid service prototyping with minimal boilerplate"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0c1554636a564da3baf037ac652fc831"

SRC_URI[md5sum] = "6aa8815652c6f5e5e8e5b2ac1813dd87"
SRC_URI[sha256sum] = "b25707c349079a7c888155e7fdfd8394df2da9aca9c8eee4e205528cb16b7662"

inherit pypi setuptools

RDEPENDS:${PN} = "\
               python-subprocess \
               python-six \
               python-argparse \
               python-re \
               python-shell \
               python-threading \
               python-logging \
               python-unixadmin \
               python-distutils \
               python-daemonize \
               python-futures \
"

SKIP_RECIPE[python-sparts] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
