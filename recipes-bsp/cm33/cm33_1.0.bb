SUMMARY = "U-Boot Env"
SECTION = "app"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}"

SRC_URI = " "

SRC_URI_rzboard = " \
            file://rzv2l_cm33_rpmsg_demo_non_secure_code.bin \
            file://rzv2l_cm33_rpmsg_demo_non_secure_vector.bin \
            file://rzv2l_cm33_rpmsg_demo_secure_code.bin \
            file://rzv2l_cm33_rpmsg_demo_secure_vector.bin \
"

FILES_${PN} = "/boot"

do_install () {
    install -d ${D}/boot/cm33
    install -m 0644 ${S}/rzv2l_cm33_rpmsg_*.bin ${D}/boot/cm33
}

inherit deploy
addtask deploy after do_install

do_deploy () {
	install -d ${DEPLOYDIR}/cm33
    install -m 0644 ${D}/boot/cm33/rzv2l_cm33_rpmsg_*.bin ${DEPLOYDIR}/cm33
}

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
