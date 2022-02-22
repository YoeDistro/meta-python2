SUMMARY = "Helper package to avoid backports/__init__.py conflicts"
DETAIL = "backports packages in python2 suffer from a flaw in the namespace \
implementation and can conflict with each other. For OE purposes, at least \
fix the conflicting install of .../site-packages/backports/__init__.py"
AUTHOR = "Tim Orling <ticotimo@gmail.com>"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://backports/__init__.py"

inherit python-dir

# provide to avoid warnings
do_compile() {
    :
}

do_install() {
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}/backports
    install ${WORKDIR}/backports/__init__.py ${D}${PYTHON_SITEPACKAGES_DIR}/backports/
}

FILES:${PN} = "${PYTHON_SITEPACKAGES_DIR}/backports/__init__.py"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-backports-init] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
