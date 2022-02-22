
SUMMARY = "An extension for the Flask microframework that adds Sijax support."
DESCRIPTION = "Flask-Sijax is an extension for the Flask microframework, to \
simplify Sijax (PyPi, GitHub) setup and usage for Flask users. \
\
Sijax is a Python/jQuery library that makes AJAX easy to use in web applications."
HOMEPAGE = "https://github.com/spantaleev/flask-sijax"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=266adc7b911b7c84b837bf77196e1ba6"

SRC_URI[sha256sum] = "fb2bf2d4f75408185102195055d75549fee8d9c9e954dca2427186925cdc429f"

PYPI_PACKAGE = "Flask-Sijax"

inherit pypi setuptools

RDEPENDS:${PN} = "${PYTHON_PN}-sijax"

SKIP_RECIPE[python-flask-sijax] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
