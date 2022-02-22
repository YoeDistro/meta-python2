SUMMARY = "PIP is a tool for installing and managing Python packages"
HOMEPAGE = "https://pip.pypa.io/"
LICENSE = "MIT & LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8ba06d529c955048e5ddd7c45459eb2e"

SRC_URI[md5sum] = "1aaaf90fbafc50e7ba1e66ffceb00960"
SRC_URI[sha256sum] = "21207d76c1031e517668898a6b46a9fb1501c7a4710ef5dfd6a40ad9e6757ea7"

inherit pypi setuptools

# Since PIP is like CPAN for PERL we need to drag in all python modules to ensure everything works
RDEPENDS:${PN}:class-target = "python-modules python-distribute python-misc"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-pip] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
