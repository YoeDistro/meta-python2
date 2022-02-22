SUMMARY = "An extension that includes Bootstrap in your project, without any boilerplate code."
DESCRIPTION = "Flask-Bootstrap packages Bootstrap into an extension that \
mostly consists of a blueprint named ‘bootstrap’. It can also create links to \
serve Bootstrap from a CDN and works with no boilerplate code in your application."
HOMEPAGE = "http://github.com/mbr/flask-bootstrap"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=a03749709f06118a17349deb5a210619"

SRC_URI[md5sum] = "e40d50f5c5b6438c1c6200a6f2871f81"
SRC_URI[sha256sum] = "cb08ed940183f6343a64e465e83b3a3f13c53e1baabb8d72b5da4545ef123ac8"

PYPI_PACKAGE = "Flask-Bootstrap"

inherit pypi setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-dominate \
    ${PYTHON_PN}-flask \
    ${PYTHON_PN}-visitor \
    "

SKIP_RECIPE[python-flask-bootstrap] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
