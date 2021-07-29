inherit python-dir

RDEPENDS:${PN} += "python-backports-init"

do_install:prepend() {
    rm -rf $(find . -path "*/backports/__init__.py" -type f)
}
