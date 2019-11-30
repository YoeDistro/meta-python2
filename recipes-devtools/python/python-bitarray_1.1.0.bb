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
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=00f0d12ccaf4e6b0b4fe501663621fa3"

SRC_URI[md5sum] = "743d396a1012d6f7d791d8a526da302d"
SRC_URI[sha256sum] = "9f578314c7808eb1416620dc7d7977d4787a65a4f61b4c9685343a860712615b"

inherit pypi setuptools

BBCLASSEXTEND = "native nativesdk"
