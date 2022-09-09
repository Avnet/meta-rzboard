ALTERNATIVE_${PN} = "resolv-conf"
ALTERNATIVE_TARGET[resolv-conf] = "${sysconfdir}/resolv-conf.systemd"
ALTERNATIVE_LINK_NAME[resolv-conf] = "${sysconfdir}/resolv.conf"

SYSTEMD_AUTO_ENABLE_${PN} = "disable"
SYSTEMD_AUTO_ENABLE_${PN}-wait-online = "disable"
