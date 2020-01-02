SUMMARY = "A high-level Python efficient arrays of booleans -- C extension"
DESCRIPTION = "This module provides an object type which efficiently represents \
an array of booleans. Bitarrays are sequence types and behave very much like \
usual lists. Eight bits are represented by one byte in a contiguous block of \
memory. The user can select between two representations: little-endian and \
big-endian. All of the functionality is implemented in C. Methods for \
accessing the machine representation are provided. This can be useful when bit \
level access to binary files is required, such as portable bitmap image files \
(.pbm). Also, when dealing with compressed data which uses variable bit length \
encoding, you may find this module useful."
HOMEPAGE = "https://github.com/ilanschnell/bitarray"
SECTION = "devel/python"

LICENSE = "PSF"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=f1c84020645d906bd6569f6bcf071eca"

SRC_URI[md5sum] = "ce21bdfb6d074bd051abd601667b238e"
SRC_URI[sha256sum] = "4f8706b651243c9faa981f075bcbdef2fab83e9b9bc9211ed2cb5849f9a68342"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"
