SUMMARY = "DRP-AI Sample Application for RZ/V2L"
SECTION = "app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEMO_FILE  =  "app_demos_v7.30.tar.bz2"
SRC_URI = "https://avtinc.sharepoint.com/:u:/t/ET-Downloads/EYIYPr9iXFBEkrrWSer0zb0BcJK_luxUno0Eh5I8EPTiaA?download=1;downloadfilename=${DEMO_FILE};unpack=0;name=demo;subdir=demo_save "
SRC_URI[demo.sha256sum] = "37dc786fa2e88356a58392a61e1c7b2c07ea5df45ff9d0a8c84f8034e4090fee"

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
