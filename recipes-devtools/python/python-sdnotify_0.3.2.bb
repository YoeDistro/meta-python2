SUMMARY = "A pure Python implementation of systemd's service notification protocol (sd_notify)"
DESCRIPTION = "\
  sdnotify is a pure Python implementation of the systemd sd_notify protocol. \
  This protocol can be used to inform systemd about service start-up completion, \
  watchdog events, and other service status changes. \
  Thus, this package can be used to write system services in Python that play nicely with systemd. \
  "
HOMEPAGE = "https://github.com/bb4242/sdnotify"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=cc572ccc4b18a4b7d13be5d01bc8213e"

SRC_URI[md5sum] = "749ddca1c70be1697fecc443fb1fdb16"
SRC_URI[sha256sum] = "73977fc746b36cc41184dd43c3fe81323e7b8b06c2bb0826c4f59a20c56bb9f1"

inherit setuptools pypi

SKIP_RECIPE[python-sdnotify] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
