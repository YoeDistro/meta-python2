SUMMARY = "The ssl.match_hostname() function from Python 3.4"
DESCRIPTION = "The Secure Sockets layer is only actually secure if you check the hostname in the \
certificate returned by the server to which you are connecting, and verify that it matches to hostname \
that you are trying to reach. But the matching logic, defined in RFC2818, can be a bit tricky to implement \
on your own. So the ssl package in the Standard Library of Python 3.2 and greater now includes a \
match_hostname() function for performing this check instead of requiring every application to \
implement the check separately. This backport brings match_hostname() to users of earlier versions of Python"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=b2adbe8bfdeb625c9a01afd9aaa66619"

SRC_URI[md5sum] = "32d2f593af01a046bec3d2f5181a420a"
SRC_URI[sha256sum] = "bb82e60f9fbf4c080eabd957c39f0641f0fc247d9a16e31e26d594d8f42b9fd2"

PYPI_PACKAGE = "backports.ssl_match_hostname"

inherit pypi setuptools python-backports-init

RDEPENDS:${PN} += "${PYTHON_PN}-pkgutil"

SKIP_RECIPE[python-backports-ssl] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
