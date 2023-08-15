SUMMARY = "RZBoard Flash Utility"
SECTION = "utility"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/avnet/rzboard_flash_util.git;branch=main;"

# Modify these as desired
PV = "1.0.0+git${SRCPV}"
SRCREV = "2d6b78c42330fffbd0b045dce473e5aaa6026fcc"

S = "${WORKDIR}/git"

do_deploy() {
	cp -r ${S}/* ${DEPLOY_DIR}/images/rzboard/
}

addtask deploy after do_compile

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
