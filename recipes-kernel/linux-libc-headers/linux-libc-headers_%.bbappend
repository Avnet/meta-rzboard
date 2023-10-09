require recipes-kernel/linux/kernel-version.inc

SRC_URI = "${KERNEL_URL};${RZBOARD_GIT_PROTOCOL};branch=${BRANCH};${RZBOARD_GIT_USER}"
