SUMMARY = "DRP-AI Sample Application for RZ/V2L"
SECTION = "app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEMO_FILE  =  "app_demos_v7.50.tar.bz2"
DEMO_URL   =  "https://avtinc.sharepoint.com/:u:/t/ET-Downloads/EZGR2UgE0j5FucwL5VGlgqcBxBhkz5qQ087WpKZZgRO6yQ?download=1"
SRC_URI[demo.sha256sum] = "0bf91012f42caa033c28c9f19b3669bb046343474c9328970637cdfb77009dc6"

SRC_URI    =  "${DEMO_URL};downloadfilename=${DEMO_FILE};unpack=0;name=demo;subdir=demo_save "

APP_INSTALL_DIRECTORY ?= "${ROOT_HOME}"
FILES_${PN} = " \
	${APP_INSTALL_DIRECTORY}/* \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${APP_INSTALL_DIRECTORY}
	install -m 0644 ${S}/demo_save/${DEMO_FILE}       ${D}${APP_INSTALL_DIRECTORY}/app_demos.tar.bz2
}

INSANE_SKIP_${PN} += "file-rdeps"

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
