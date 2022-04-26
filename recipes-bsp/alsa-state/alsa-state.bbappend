# Copyright David.fu <david.fu@avnet.com>
# asound.state for DA7212

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
         file://asound.state \
         file://asound.conf \
"

do_install_append_rzboard () {
    install -m 0644 ${WORKDIR}/asound.state ${D}${localstatedir}/lib/alsa
    install -m 0644 ${WORKDIR}/asound.conf ${D}${sysconfdir}
}
