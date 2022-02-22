SUMMARY = "A Python crypto and SSL toolkit"
HOMEPAGE = "https://gitlab.com/m2crypto/m2crypto"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE;md5=b0e1f0b7d0ce8a62c18b1287b991800e"

FILESEXTRAPATHS:prepend := "${THISDIR}/python-m2crypto:"

SRC_URI += "file://0001-setup.py-link-in-sysroot-not-in-host-directories.patch \
            file://cross-compile-platform.patch \
            file://m2crypto-0.26.4-gcc_macros.patch \
           "
SRC_URI[md5sum] = "7fce3cbf85eb84a669682892b935746b"
SRC_URI[sha256sum] = "a1b2751cdadc6afac3df8a5799676b7b7c67a6ad144bb62d38563062e7cd3fc6"

DEPENDS += "openssl swig-native"

PYPI_PACKAGE = "M2Crypto"

inherit pypi siteinfo setuptools

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-distutils \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-netserver \
    ${PYTHON_PN}-smtpd \
    ${PYTHON_PN}-typing \
    ${PYTHON_PN}-xmlrpc \
    "

DISTUTILS_BUILD_ARGS += "build_ext --openssl=${STAGING_EXECPREFIXDIR} -I${STAGING_INCDIR}"
DISTUTILS_INSTALL_ARGS += "build_ext --openssl=${STAGING_EXECPREFIXDIR}"

SWIG_FEATURES:x86 = "-D__i386__"
SWIG_FEATURES_x32 = "-D__ILP32__"
SWIG_FEATURES ?= "-D__${HOST_ARCH}__"
export SWIG_FEATURES

# Get around a problem with swig, but only if the
# multilib header file exists.
#
do_configure:prepend() {
    ${CPP} -dM - < /dev/null | grep -v '__\(STDC\|REGISTER_PREFIX\|GNUC\|STDC_HOSTED\)__' \
    | sed 's/^\(#define \([^ ]*\) .*\)$/#undef \2\n\1/' > ${S}/SWIG/gcc_macros.h

    if [ "${SITEINFO_BITS}" = "64" ];then
        bit="64"
    else
        bit="32"
    fi

    if [ -e ${STAGING_INCDIR}/openssl/opensslconf-${bit}.h ] ;then
        for i in SWIG/_ec.i SWIG/_evp.i; do
            sed -i -e "s/opensslconf.*\./opensslconf-${bit}\./" "${S}/$i"
        done
    elif [ -e ${STAGING_INCDIR}/openssl/opensslconf-n${bit}.h ] ;then
        for i in SWIG/_ec.i SWIG/_evp.i; do
            sed -i -e "s/opensslconf.*\./opensslconf-n${bit}\./" "${S}/$i"
        done
    fi
}

BBCLASSEXTEND = "native"

SKIP_RECIPE[python-m2crypto] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', 'Not compatible with openssl-3, http://errors.yoctoproject.org/Errors/Details/614896/ SWIG/_m2crypto_wrap.c:32981:102: error: RSA_SSLV23_PADDING undeclared (first use in this function); did you mean RSA_NO_PADDING?', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
SKIP_RECIPE[python-m2crypto-native] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', 'Not compatible with openssl-3, http://errors.yoctoproject.org/Errors/Details/614896/ SWIG/_m2crypto_wrap.c:32981:102: error: RSA_SSLV23_PADDING undeclared (first use in this function); did you mean RSA_NO_PADDING?', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
