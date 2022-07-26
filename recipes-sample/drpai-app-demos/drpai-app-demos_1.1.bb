SUMMARY = "DRP-AI Sample Application for RZ/V2L"
SECTION = "app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "https://docs.avnet.com/amer/smart_channel/Renesas/Rzboard_v2l/app_demos_v7.10.tar.bz2;name=demo;subdir=demo_save "
SRC_URI[demo.sha256sum] = "3967f297a0ca788c976ad70106420ef444533499aea5ab25784e76836894afdc"

APP_INSTALL_DIRECTORY ?= "${ROOT_HOME}"
FILES_${PN} = " \
	${APP_INSTALL_DIRECTORY}/* \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${APP_INSTALL_DIRECTORY}
	cp -rf ${S}/demo_save/*        ${D}${APP_INSTALL_DIRECTORY}
}

INSANE_SKIP_${PN} += "file-rdeps"

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
