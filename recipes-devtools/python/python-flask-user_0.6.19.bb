SUMMARY = "Customizable user account management for Flask"
DESCRIPTION = "Customizable User Account Management for Flask; Register \
Confirm email, Login, Change username, Change password, Forgot Password \
and more."
HOMEPAGE = " https://github.com/lingthio/Flask-User"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=97de97cd9d6e23c88129d884588ce71a"

SRC_URI[md5sum] = "f7965e66ca139c8436896da07e66c21f"
SRC_URI[sha256sum] = "601abcc0343dfbae0c56273d98362d5cdc266ac84d20b3f65a212e4a2c83b302"

PYPI_PACKAGE = "Flask-User"

inherit pypi setuptools

RDEPENDS:${PN} = "${PYTHON_PN}-flask \
    ${PYTHON_PN}-flask-login \
    ${PYTHON_PN}-flask-mail \
    ${PYTHON_PN}-babel"

SKIP_RECIPE[python-flask-user] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
