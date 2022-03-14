
DESCRIPTION = "Wireless Module Start Service"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

FILES_${PN} += "/etc/*"

# Firmware for NXP wireless Modules
SRC_URI += " \ 
            file://moal.conf_load \
            file://moal.conf_probe \
            file://30-mlan0-dhcp.network \
            file://wpa_supplicant-mlan0.conf \
"

do_install_append () {
	install -d ${D}${sysconfdir}/systemd/network
	install -d ${D}${sysconfdir}/wpa_supplicant/
	install -d ${D}${sysconfdir}/modprobe.d/
	install -d ${D}${sysconfdir}/modules-load.d/

	install -m 0644 ${WORKDIR}/30-mlan0-dhcp.network ${D}${sysconfdir}/systemd/network/
	install -m 0644 ${WORKDIR}/wpa_supplicant-mlan0.conf ${D}${sysconfdir}/wpa_supplicant/
	install -m 0644 ${WORKDIR}/moal.conf_probe ${D}${sysconfdir}/modprobe.d/moal.conf
	install -m 0644 ${WORKDIR}/moal.conf_load ${D}${sysconfdir}/modules-load.d/moal.conf
}

