require python-setuptools.inc

PROVIDES = "python-distribute"

inherit setuptools

RREPLACES:${PN} = "python-distribute"
RPROVIDES:${PN} = "python-distribute"
RCONFLICTS:${PN} = "python-distribute"

SKIP_RECIPE[python-setuptools] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
