DESCRIPTION = "Python SQL toolkit and Object Relational Mapper that gives \
application developers the full power and flexibility of SQL"
HOMEPAGE = "http://www.sqlalchemy.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2f5eb030c48975d5294baf0f5d01af1c"

PYPI_PACKAGE = "SQLAlchemy"

inherit pypi setuptools

SRC_URI[md5sum] = "02a46be841903b60c52a83342d3ced8e"
SRC_URI[sha256sum] = "bfb8f464a5000b567ac1d350b9090cf081180ec1ab4aa87e7bca12dab25320ec"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-pickle \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-threading \
"


SKIP_RECIPE[python-sqlalchemy] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
