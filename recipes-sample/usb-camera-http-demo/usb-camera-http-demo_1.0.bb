SUMMARY = "RZ/V2L DRP-AI USB Camera HTTP Demo"
SECTION = "app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEMO_FILE  =  "usb_camera_http_demo.tar.bz2"
SRC_URI = "\
        https://avtinc.sharepoint.com/:u:/t/ET-Downloads/ERbbdxpa9lBLrTLc1oB36icB_pYg1czEoCEv2fD_QckdaQ?download=1;downloadfilename=${DEMO_FILE};name=demo;subdir=demo_save \
        git://github.com/avnet/rzboard_usb_http_demo.git;branch=main; \
"
SRC_URI[demo.sha256sum] = "b97df768776dd8fe9b31a47973adc8141be7fb17f5cdc0759f1f3ccf16d73879"

# Modify these as desired
PV = "1.0.0+git${SRCPV}"
SRCREV = "b22a54ee7513a4325708d43cc8212cfb70dfc3d3"

APP_INSTALL_DIRECTORY ?= "${ROOT_HOME}"
FILES_${PN} = " \
        ${APP_INSTALL_DIRECTORY} \
        ${APP_INSTALL_DIRECTORY}/usb_cam_http \
        ${APP_INSTALL_DIRECTORY}/usb_cam_http/* \
        ${APP_INSTALL_DIRECTORY}/demos \
        ${APP_INSTALL_DIRECTORY}/demos/* \
"

inherit pkgconfig cmake
S = "${WORKDIR}/git/usbcam_http_drp-ai/src"

DEPENDS += " libjpeg-turbo"
R_DEPENDS += " libjpeg-turbo"

do_install() {
        install -d ${D}${APP_INSTALL_DIRECTORY}
        install -d ${D}${APP_INSTALL_DIRECTORY}/demos
        cp -r ${WORKDIR}/demo_save/usb_cam_http ${D}${APP_INSTALL_DIRECTORY}
        cp ${WORKDIR}/build/sample_app_usbcam_http ${D}${APP_INSTALL_DIRECTORY}/usb_cam_http/usb_camera_http_demo
        cp -r ${WORKDIR}/git/usbcam_http_drp-ai/etc/usbCameraHttpDemo ${D}${APP_INSTALL_DIRECTORY}/demos
}

INSANE_SKIP_${PN} += "file-rdeps"

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
