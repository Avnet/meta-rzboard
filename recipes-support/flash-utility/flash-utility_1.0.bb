SUMMARY = "RZBoard Flash Utility"
SECTION = "utility"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/avnet/rzboard_flash_util.git;branch=main;"

PV = "1.0.1+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

do_deploy() {
	cp -r ${S}/* ${DEPLOY_DIR}/images/rzboard/
}

addtask deploy after do_compile

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
