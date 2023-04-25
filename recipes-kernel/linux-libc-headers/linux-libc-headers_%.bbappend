KERNEL_URL = " ${RZBOARD_GIT_HOST_MIRROR}/renesas-linux-cip.git"
BRANCH = "rzboard_v2l_v5.10_no_isp"
SRCREV = "7946db09c58adf060ed4ff71ac3fbf983dcab834"

SRC_URI = "${KERNEL_URL};${RZBOARD_GIT_PROTOCOL};branch=${BRANCH};${RZBOARD_GIT_USER}"
