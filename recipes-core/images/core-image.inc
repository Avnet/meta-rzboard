SUMMARY = "Yocto Linux System Image for Avnet RzBoard"
LICENSE = "MIT"

inherit core-image features_check

REQUIRED_DISTRO_FEATURES = "wayland"

CORE_IMAGE_BASE_INSTALL += "weston weston-init"
CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)}"

# Basic packages
require include/core-image-renesas-base.inc
require include/core-image-renesas-mmp.inc
require include/core-image-bsp.inc

# Add DRP-AI packages
require include/drpai/core-image-sdk.inc
require include/drpai/extend_packages.inc

IMAGE_INSTALL_append = " opencv opencv-dev "
##TOOLCHAIN_TARGET_TASK_append = " drpai "
TOOLCHAIN_TARGET_TASK_append = " isp "

# Add CM33 example
IMAGE_INSTALL_append = " cm33"


IMAGE_FEATURES_remove = " ssh-server-dropbear"
IMAGE_FEATURES_append = " ssh-server-openssh"

IMAGE_INSTALL_remove = " \
    optee-client \
    v4l2-init \
"

ROOTFS_POSTPROCESS_COMMAND_remove= "update_issue;"

# Additional packages
IMAGE_INSTALL_append = " \
    curl \
    openssh \
    alsa-state \
    gnupg \
    evtest \
    spitools \
    xz \
    udev-extraconf \
    vim \
    nano \
"

# Wifi/Bluetooth packages
IMAGE_INSTALL_append = " \
    wireless-tools \
    wpa-supplicant \
    hostapd \
    obexftp \
    bluez5 \
    bluez5-dev \
    rzboard-firmware \
"

CORE_IMAGE_EXTRA_INSTALL += " packagegroup-tools-bluetooth "

# Add app demos
IMAGE_INSTALL_append = " drpai-app-demos rzboard-app-script"

unzip_drpai_demo() {
    DEMO_FILE=app_demos.tar.bz2

    if [ -e ${IMAGE_ROOTFS}/home/root/${DEMO_FILE} ] ; then
        tar -x -j -f ${IMAGE_ROOTFS}/home/root/${DEMO_FILE} -C ${IMAGE_ROOTFS}/home/root/
        rm ${IMAGE_ROOTFS}/home/root/${DEMO_FILE}
    fi
}
ROOTFS_POSTPROCESS_COMMAND += "unzip_drpai_demo; "

# Add extra packages for RzBoard
inherit extrausers
EXTRA_USERS_PARAMS = "\
	usermod -P avnet root; \
"
# rootfs partition space created in Kbytes
IMAGE_ROOTFS_SIZE = "2560000"

# the alignment of the root filesystem image in kilobytes.
IMAGE_ROOTFS_ALIGNMENT = "16"
