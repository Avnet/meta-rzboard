
UBOOT_URL = "${RZBOARD_GIT_HOST_MIRROR}/renesas-u-boot.git"
BRANCH = "rzboard_v2l_v2021.10_r3"
SRCREV = "e3204dcc685a46877c1b3a24c5c60f7398383900"

SRC_URI = "${UBOOT_URL};branch=${BRANCH};${RZBOARD_GIT_PROTOCOL};${RZBOARD_GIT_USER}"
