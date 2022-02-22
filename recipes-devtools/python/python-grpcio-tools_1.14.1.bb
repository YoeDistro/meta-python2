SUMMARY = "Protobuf code generator for gRPC"
DESCRIPTION = "Google gRPC tools"
HOMEPAGE = "http://www.grpc.io/"
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=7145f7cdd263359b62d342a02f005515"

SRC_URI[md5sum] = "b2fabfb54c7824c1e49a02de2aa6628e"
SRC_URI[sha256sum] = "4ce5aa660d7884f23aac1eafa93b97a4c3e2b512edff871e91fdb6ee86ebd5ea"

DEPENDS:append = " ${PYTHON_PN}-grpcio"

inherit pypi setuptools

RDEPENDS:${PN} = "${PYTHON_PN}-grpcio"

BBCLASSEXTEND = "native nativesdk"

SKIP_RECIPE[python-grpcio-tools] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
