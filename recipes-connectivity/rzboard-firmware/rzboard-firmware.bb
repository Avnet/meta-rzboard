
DESCRIPTION = "RzBoard wireless firmware"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

FILES_${PN} += "/lib/firmware/nxp/*"

# Firmware for NXP wireless Modules
SRC_URI += " \ 
            file://rzboard-firmware.tar.bz2;unpack=true;subdir=rzboard-firmware \
"

# NXP Based Wireless Modules Murata 1ZM(88W8987)
do_install_append () {
	install -d ${D}${nonarch_base_libdir}/firmware/nxp/

    install -m 0644 ${WORKDIR}/rzboard-firmware/nxp/wifi_mod_para.conf ${D}${nonarch_base_libdir}/firmware/nxp/
    install -m 0644 ${WORKDIR}/rzboard-firmware/nxp/sdiouart8987_combo_v0.bin ${D}${nonarch_base_libdir}/firmware/nxp/
}

