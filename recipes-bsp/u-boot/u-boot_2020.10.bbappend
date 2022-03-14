
UBOOT_URL = "${RZBOARD_GIT_HOST_MIRROR}/renesas-u-boot.git"
BRANCH = "rzboard_v2l_v2020.10"
SRCREV = "5b4b7a3ced8c7e882f24c2fa49bf5ce6f12447a4"

# When using private git repo, you can append ";user=username:password" to SRC_URI
# to download the remote repo.
SRC_URI = "${UBOOT_URL};branch=${BRANCH};protocol=http;${RZBOARD_GIT_USER}"
