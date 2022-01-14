DEPENDS  += "${@["${PYTHON_PN}-native ${PYTHON_PN}", ""][(d.getVar('PACKAGES') == '')]}"
RDEPENDS:${PN} += "${@['', '${PYTHON_PN}-core']['${CLASSOVERRIDE}' == 'class-target']}"

inherit pythonnative

# the rest is meta/classes/distutils-common-base.bbclass before the bb.warn was added in:
# https://git.openembedded.org/openembedded-core/commit/?id=54b455049ee94c01c78b31b6c744c8e32b5b7737
# as the distutils removal in Python 3.12 doesn't affect already EOL Python2 recipes

export STAGING_INCDIR
export STAGING_LIBDIR

# LDSHARED is the ld *command* used to create shared library
export LDSHARED  = "${CCLD} -shared"
# LDXXSHARED is the ld *command* used to create shared library of C++
# objects
export LDCXXSHARED  = "${CXX} -shared"
# CCSHARED are the C *flags* used to create objects to go into a shared
# library (module)
export CCSHARED  = "-fPIC -DPIC"
# LINKFORSHARED are the flags passed to the $(CC) command that links
# the python executable
export LINKFORSHARED = "${SECURITY_CFLAGS} -Xlinker -export-dynamic"

FILES:${PN} += "${libdir}/* ${libdir}/${PYTHON_DIR}/*"

FILES:${PN}-staticdev += "\
  ${PYTHON_SITEPACKAGES_DIR}/*.a \
"
FILES:${PN}-dev += "\
  ${datadir}/pkgconfig \
  ${libdir}/pkgconfig \
  ${PYTHON_SITEPACKAGES_DIR}/*.la \
"
