SUMMARY = "Gstreamer H.264 USB camera video streaming for RzBoard"
SECTION = "app"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "file://streamVideo.sh "
SRC_URI[sha256sum] = "0f0c8866ea0b8ee2ac3800ccf269eb4c0dd7bdc0c7f7f24f65e2e918c529616e"

APP_INSTALL_DIRECTORY ?= "${ROOT_HOME}"
FILES_${PN} = " \
	${APP_INSTALL_DIRECTORY}/*.sh \
"

do_install() {
	install -d ${D}${APP_INSTALL_DIRECTORY}
	install -m 0755 ${WORKDIR}/streamVideo.sh    ${D}${APP_INSTALL_DIRECTORY}
}

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
