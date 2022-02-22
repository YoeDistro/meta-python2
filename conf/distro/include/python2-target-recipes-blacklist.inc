# recipes from this layer already have SKIP_RECIPE inside the recipes

# from other layers:
# meta-oe/recipes-dbs/mysql/mysql-python_1.2.5.bb
SKIP_RECIPE[mysql-python] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this , then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
RDEPENDS:packagegroup-meta-oe-dbs-python2:remove = "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'mysql-python', d)}"
# meta-oe/recipes-support/lio-utils/lio-utils_4.1.bb
SKIP_RECIPE[lio-utils] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
RDEPENDS:packagegroup-meta-oe-support-python2:remove = "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'lio-utils', d)}"
