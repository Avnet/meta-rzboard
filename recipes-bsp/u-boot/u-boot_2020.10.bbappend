
UBOOT_URL = "${RZBOARD_GIT_HOST_MIRROR}/renesas-u-boot.git"
BRANCH = "rzboard_v2l_v2020.10"
SRCREV = "9aadbdcd5666dc389c737cf13cb4490306ba8d2e"

# When using private git repo, you can append ";user=username:password" to SRC_URI
# to download the remote repo.
SRC_URI = "${UBOOT_URL};branch=${BRANCH};${RZBOARD_GIT_PROTOCOL};${RZBOARD_GIT_USER}"
