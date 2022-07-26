SUMMARY = "Yocto Linux System Image for Avnet RzBoard"
LICENSE = "MIT"

inherit core-image features_check

REQUIRED_DISTRO_FEATURES = "wayland"

CORE_IMAGE_BASE_INSTALL += "weston weston-init"
CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)}"

CORE_IMAGE_EXTRA_INSTALL += " \
							 packagegroup-core-full-cmdline \
							 packagegroup-tools-bluetooth \
"

IMAGE_INSTALL_append = " opencv opencv-dev "

# Basic packages
IMAGE_INSTALL_append = " \
    curl \
    bonnie++ \
    v4l-utils \
    i2c-tools \
    busybox \
    libusb1 \
    pciutils \
    can-utils \
    iperf3 \
    openssh \
    openssh-sshd \
    usbutils \
    mtd-utils \
    dosfstools \
    e2fsprogs-badblocks \
    e2fsprogs-dumpe2fs \
    e2fsprogs-e2fsck \
    e2fsprogs-e2scrub \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    minicom \
    memtester \
    alsa-utils \
    alsa-state \
    libdrm \
    libdrm-tests \
    yavta \
    kernel-module-uvcvideo \
	glib-2.0 \
    gnupg \
    wpa-supplicant \
    hostapd \
    evtest \
    spitools \
    xz \
    udev-extraconf \
	wireless-tools \
	bluez5 \
	rzboard-firmware \
	wlan-conf \
	libmetal \
	open-amp \
	rpmsg-sample \
	cm33 \
"
# Add text editor
IMAGE_INSTALL_append = " vim nano"

IMAGE_INSTALL_append = " \
                packagegroup-multimedia-libs \
                packagegroup-multimedia-kernel-modules \
"

IMAGE_INSTALL_append = " \
	packagegroup-gstreamer1.0-plugins \
	packagegroup-wayland-community \
"

# Add app demos
IMAGE_INSTALL_append = " drpai-app-demos"

IMAGE_FEATURES_remove = " ssh-server-dropbear"
IMAGE_FEATURES_append = " ssh-server-openssh"

# Renesas Basic packages for 32bit
BASIC_32BIT_PKGS = " \
    lib32-coreutils \
    lib32-libstdc++ \
"

# Installation for 32bit packages
IMAGE_INSTALL_append = " \
    ${@oe.utils.conditional("USE_32BIT_PKGS", "1", "${BASIC_32BIT_PKGS}", "", d)} \
"

inherit extrausers
EXTRA_USERS_PARAMS = "\
	usermod -P avnet root; \
"
# rootfs partition space created in Kbytes
IMAGE_ROOTFS_SIZE = "2560000"

# the alignment of the root filesystem image in kilobytes.
IMAGE_ROOTFS_ALIGNMENT = "16"
