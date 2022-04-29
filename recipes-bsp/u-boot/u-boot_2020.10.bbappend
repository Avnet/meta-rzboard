
UBOOT_URL = "${RZBOARD_GIT_HOST_MIRROR}/renesas-u-boot.git"
BRANCH = "rzboard_v2l_v2020.10"
SRCREV = "${AUTOREV}"

# When using private git repo, you can append ";user=username:password" to SRC_URI
# to download the remote repo.
SRC_URI = "${UBOOT_URL};branch=${BRANCH};protocol=http;${RZBOARD_GIT_USER}"
