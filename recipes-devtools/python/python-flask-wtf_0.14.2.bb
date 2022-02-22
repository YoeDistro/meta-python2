SUMMARY = "Simple integration of Flask and WTForms."
DESCRIPTION = "Simple integration of Flask and WTForms, including CSRF, file \
upload, and reCAPTCHA."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3ca6bb31670492f791e6a9f2fb9f8a80"

SRC_URI[md5sum] = "586f50f233926cade42e3d744aca3e8f"
SRC_URI[sha256sum] = "5d14d55cfd35f613d99ee7cba0fc3fbbe63ba02f544d349158c14ca15561cc36"

PYPI_PACKAGE = "Flask-WTF"

inherit pypi setuptools

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-flask \
    ${PYTHON_PN}-itsdangerous \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-wtforms \
"

SKIP_RECIPE[python-flask-wtf] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
