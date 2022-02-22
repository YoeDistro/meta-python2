require  meta-python2-image-base.bb

SUMMARY = "meta-python2 ptest test image"

IMAGE_INSTALL += "packagegroup-meta-python2-ptest"

SKIP_RECIPE[meta-python2-ptest-image.bb] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
