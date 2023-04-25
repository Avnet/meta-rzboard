SUMMARY = "DRP-AI Sample Application for RZ/V2L"
SECTION = "app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEMO_FILE  =  "app_demos_v7.20.tar.bz2"
SRC_URI = "https://avtinc.sharepoint.com/:u:/t/ET-Downloads/EWFEYue2icpHtdo1bGOZeZsBCMbdPQLO8NdHuLiv2CNHZw?download=1;downloadfilename=${DEMO_FILE};unpack=1;name=demo;subdir=demo_save "
SRC_URI[demo.sha256sum] = "3250771db905dba822bb062d80931af60c5f0d500a089a536c7db03ef6485d7b"

APP_INSTALL_DIRECTORY ?= "${ROOT_HOME}"
FILES_${PN} = " \
	${APP_INSTALL_DIRECTORY}/* \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${APP_INSTALL_DIRECTORY}
	cp -r ${S}/demo_save/app_demos ${D}${APP_INSTALL_DIRECTORY}
}

INSANE_SKIP_${PN} += "file-rdeps"

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
