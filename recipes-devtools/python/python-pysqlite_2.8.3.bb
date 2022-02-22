SUMMARY = "DB-API 2.0 interface for SQLite 3.x"
DESCRIPTION = "pysqlite is an interface to the SQLite 3.x embedded relational \
database engine. It is almost fully compliant with the Python database API \
version 2.0 also exposes the unique features of SQLite."
HOMEPAGE = "http://github.com/ghaering/pysqlite"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE;md5=28ad4f115e06c88bd737372a453369d8"

SRC_URI[md5sum] = "033f17b8644577715aee55e8832ac9fc"
SRC_URI[sha256sum] = "17d3335863e8cf8392eea71add33dab3f96d060666fe68ab7382469d307f4490"

inherit pypi setuptools

DEPENDS += "${PYTHON_PN}-pip"

RDEPENDS:${PN}:class-target += "\
    ${PYTHON_PN}-datetime \
    sqlite3 \
"

FILES:${PN}-doc += "${datadir}"

SKIP_RECIPE[python-pysqlite] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
