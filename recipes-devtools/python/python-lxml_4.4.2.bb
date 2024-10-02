SUMMARY = "Powerful and Pythonic XML processing library combining libxml2/libxslt with the ElementTree API."
DESCRIPTION = "lxml is a Pythonic, mature binding for the libxml2 and \
libxslt libraries. It provides safe and convenient access to these \
libraries using the ElementTree API. It extends the ElementTree API \
significantly to offer support for XPath, RelaxNG, XML Schema, XSLT, \
C14N and much more."
HOMEPAGE = "http://codespeak.net/lxml"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause & GPL-2.0-only & MIT & PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSES.txt;md5=e4c045ebad958ead4b48008f70838403 \
                    file://doc/licenses/elementtree.txt;md5=eb34d036a6e3d56314ee49a6852ac891 \
                    file://doc/licenses/BSD.txt;md5=700a1fc17f4797d4f2d34970c8ee694b \
                    file://doc/licenses/GPL.txt;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://src/lxml/isoschematron/resources/rng/iso-schematron.rng;beginline=2;endline=7;md5=fc85684a8dd5fa272c086bceb0d99e10 \
                    file://src/lxml/isoschematron/resources/xsl/iso-schematron-xslt1/iso_schematron_message.xsl;beginline=2;endline=24;md5=cc86b7b2bbc678e13f58ea403eb9929b \
                    file://src/lxml/isoschematron/resources/xsl/RNG2Schtrn.xsl;beginline=2;endline=7;md5=5b03236d293dc3784205542b409d2f53 \
                    "

SRC_URI[md5sum] = "235c1a22d97a174144e76b66ce62ae46"
SRC_URI[sha256sum] = "eff69ddbf3ad86375c344339371168640951c302450c5d3e9936e98d6459db06"

DEPENDS += "libxml2 libxslt"

inherit pypi setuptools pkgconfig

# add to the defaults which are set in the setuptools bbclass
#
DISTUTILS_BUILD_ARGS += " \
                     --with-xslt-config='pkg-config libxslt' \
                     --with-xml2-config='pkg-config libxml-2.0' \
"

DISTUTILS_INSTALL_ARGS += " \
                     --with-xslt-config='pkg-config libxslt' \
                     --with-xml2-config='pkg-config libxml-2.0' \
"

# {standard input}: Assembler messages:
# {standard input}:1488805: Error: branch out of range
DEBUG_OPTIMIZATION:remove:mips = " -Og"
DEBUG_OPTIMIZATION:append:mips = " -O"
BUILD_OPTIMIZATION:remove:mips = " -Og"
BUILD_OPTIMIZATION:append:mips = " -O"

DEBUG_OPTIMIZATION:remove:mipsel = " -Og"
DEBUG_OPTIMIZATION:append:mipsel = " -O"
BUILD_OPTIMIZATION:remove:mipsel = " -Og"
BUILD_OPTIMIZATION:append:mipsel = " -O"

RDEPENDS:${PN} += "libxml2 libxslt ${PYTHON_PN}-compression"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-lxml] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
