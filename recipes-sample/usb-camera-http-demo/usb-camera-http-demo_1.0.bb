SUMMARY = "RZ/V2L DRP-AI USB Camera HTTP Demo"
SECTION = "app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "\
        file://start_usbcam_http.sh \
        git://github.com/avnet/rzboard_usb_http_demo.git;branch=main; \
"
SRC_URI[demo.sha256sum] = "d581a4b576e43b1da25182d5a77068ac7a306562d03880c69a42ea28509440a9"

# Modify these as desired
PV = "2.0.0+git${SRCPV}"
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
        install -d ${D}${APP_INSTALL_DIRECTORY}/usb_cam_http

        install -m 0755 ${WORKDIR}/start_usbcam_http.sh    ${D}${APP_INSTALL_DIRECTORY}/usb_cam_http
        cp -r ${WORKDIR}/git/usbcam_http_drp-ai/etc/usbCameraHttpDemo ${D}${APP_INSTALL_DIRECTORY}/demos

        cd ${D}${APP_INSTALL_DIRECTORY}/usb_cam_http
        ln -sf start_usbcam_http.sh usb_camera_http_demo
}

INSANE_SKIP_${PN} += "file-rdeps"

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
