SUMMARY = "Pyflame: A Ptracing Profiler For Python"
DESCRIPTION = "Pyflame is a high performance profiling tool that generates \
flame graphs for Python. Pyflame is implemented in C++, and uses the Linux \
ptrace(2) system call to collect profiling information. It can take snapshots \
of the Python call stack without explicit instrumentation, meaning you can \
profile a program without modifying its source code. Pyflame is capable of \
profiling embedded Python interpreters like uWSGI. It fully supports profiling \
multi-threaded Python programs."
HOMEPAGE = "https://github.com/uber/pyflame"
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI = "git://github.com/uber/pyflame.git;protocol=https;nobranch=1"
# v1.6.7
SRCREV = "c151d2f34737f28a1f5266a003b2b0720bbd9f96"

DEPENDS = "python"

S = "${WORKDIR}/git"

inherit pkgconfig autotools

COMPATIBLE_HOST:libc-musl:class-target = "null"
COMPATIBLE_HOST:mipsarch:class-target = "null"
COMPATIBLE_HOST:aarch64:class-target = "null"
COMPATIBLE_HOST:powerpc:class-target = "null"
COMPATIBLE_HOST:riscv64:class-target = "null"
COMPATIBLE_HOST:riscv32:class-target = "null"

SKIP_RECIPE[python-pyflame] ?= "${@bb.utils.contains('I_SWEAR_TO_MIGRATE_TO_PYTHON3', 'yes', '', 'python2 is out of support for long time, read https://www.python.org/doc/sunset-python-2/ https://python3statement.org/ and if you really have to temporarily use this, then set I_SWEAR_TO_MIGRATE_TO_PYTHON3 to "yes"', d)}"
