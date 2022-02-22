SUMMARY = "A pure-Python SNMPv1/v2c/v3 library"
DESCRIPTION = "SNMP v1/v2c/v3 engine and apps written in pure-Python. \
  Supports Manager/Agent/Proxy roles, scriptable MIBs, asynchronous \
  operation (asyncio, twisted, asyncore) and multiple transports.\
"
HOMEPAGE = "https://pypi.python.org/pypi/pysnmp"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=b15d29f500f748d1c2a15709769090a8"

SRCNAME = "pysnmp"

SRC_URI = "https://files.pythonhosted.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "6d1b514997326bed18f1ae1510f6b1c9"
SRC_URI[sha256sum] = "d5d1e59780126e963dd92e25993b783295734e71bef181f602e51f7393260441"


S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS:${PN} += "python-pycryptodomex \
                   python-pyasn1 \
                   python-pysmi \
"

SKIP_RECIPE[python-pysnmp] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
