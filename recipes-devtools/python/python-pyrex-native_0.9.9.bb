require python-pyrex_${PV}.bb
inherit native pythonnative
DEPENDS = "python-native"
RDEPENDS:${PN} = ""
PR = "r3"

SKIP_RECIPE[python-pyrex-native] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
