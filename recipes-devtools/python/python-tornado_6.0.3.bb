
SUMMARY  = "Tornado is an open source version of the scalable, non-blocking web server and tools that power FriendFeed."
DESCRIPTION = "Tornado is a Python web framework and asynchronous networking library, originally developed at FriendFeed. \
By using non-blocking network I/O, Tornado can scale to tens of thousands of open connections, making it ideal for long \
polling, WebSockets, and other applications that require a long-lived connection to each user."
HOMEPAGE = "http://www.tornadoweb.org/en/stable/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[md5sum] = "cab4b11480f6d032e46465586192d343"
SRC_URI[sha256sum] = "c845db36ba616912074c5b1ee897f8e0124df269468f25e4fe21fe72f6edd7a9"

RDEPENDS:${PN} += "${PYTHON_PN}-compression ${PYTHON_PN}-numbers ${PYTHON_PN}-email \
                   ${PYTHON_PN}-pkgutil ${PYTHON_PN}-html ${PYTHON_PN}-json ${PYTHON_PN}-certifi ${PYTHON_PN}-threading \
                   ${PYTHON_PN}-ctypes"

RDEPENDS:${PN}-test += "${PN} ${PYTHON_PN}-unittest"

PACKAGES =+ "\
    ${PN}-test \
"

FILES:${PN}-test = " \
    ${libdir}/${PYTHON_DIR}/site-packages/*/test \
    ${libdir}/${PYTHON_DIR}/site-packages/*/testing.py* \
"

inherit pypi setuptools

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-backports-abc \
    ${PYTHON_PN}-backports-ssl \
    ${PYTHON_PN}-singledispatch \
    ${PYTHON_PN}-subprocess \
"

SKIP_RECIPE[python-tornado] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
