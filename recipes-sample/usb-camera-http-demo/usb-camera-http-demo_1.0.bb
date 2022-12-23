SUMMARY = "RZ/V2L DRP-AI USB Camera HTTP Demo"
SECTION = "app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEMO_FILE  =  "usb_camera_http_demo.tar.bz2"
SRC_URI = "https://avtinc.sharepoint.com/:u:/t/ET-Downloads/ERbbdxpa9lBLrTLc1oB36icB_pYg1czEoCEv2fD_QckdaQ?download=1;downloadfilename=${DEMO_FILE};unpack=0;name=demo;subdir=demo_save "
SRC_URI[demo.sha256sum] = "b97df768776dd8fe9b31a47973adc8141be7fb17f5cdc0759f1f3ccf16d73879"

APP_INSTALL_DIRECTORY ?= "${ROOT_HOME}"
FILES_${PN} = " \
	${APP_INSTALL_DIRECTORY}/* \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${APP_INSTALL_DIRECTORY}
	install -m 0644 ${S}/demo_save/${DEMO_FILE}       ${D}${APP_INSTALL_DIRECTORY}/usbcam_http.tar.bz2
}

INSANE_SKIP_${PN} += "file-rdeps"

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
