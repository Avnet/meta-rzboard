DESCRIPTION = "Linux kernel for RzBoard"

require recipes-kernel/linux/linux-yocto.inc
require include/docker-control.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/:"
COMPATIBLE_MACHINE = "(smarc-rzg2l|smarc-rzv2l|rzv2l-dev|rzboard)"

KERNEL_URL = "${RZBOARD_GIT_HOST_MIRROR}/renesas-linux-cip.git"
BRANCH = "rzboard_v2l_v5.10.145"
SRCREV = "af8fe024cdc04df065591f7aa2983339e3066ea0"

SRC_URI = "${KERNEL_URL};${RZBOARD_GIT_PROTOCOL};nocheckout=1;branch=${BRANCH};${RZBOARD_GIT_USER}"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
LINUX_VERSION ?= "5.10.145"

PV = "${LINUX_VERSION}+git${SRCPV}"
PR = "r1"

SRC_URI_append = "\
  ${@oe.utils.conditional("USE_DOCKER", "1", " file://docker.cfg ", "", d)} \
"

B = "${WORKDIR}/build"

SHORT_SRCREV = "${@d.getVar('PV').split('+')[2]}"
LINUX_VERSION_EXTENSION = "-g${SHORT_SRCREV}"

KBUILD_DEFCONFIG = "rzboard_defconfig"
KCONFIG_MODE = "alldefconfig"

do_kernel_metadata_af_patch() {
    # need to recall do_kernel_metadata after do_patch for some patches applied to defconfig
    rm -f ${WORKDIR}/defconfig
    do_kernel_metadata
}

addtask do_kernel_metadata_af_patch after do_patch before do_kernel_configme

# Fix race condition, which can causes configs in defconfig file be ignored
do_kernel_configme[depends] += "virtual/${TARGET_PREFIX}binutils:do_populate_sysroot"
do_kernel_configme[depends] += "virtual/${TARGET_PREFIX}gcc:do_populate_sysroot"
do_kernel_configme[depends] += "bc-native:do_populate_sysroot bison-native:do_populate_sysroot"

# Fix error: openssl/bio.h: No such file or directory
DEPENDS += "openssl-native"

# Auto load Wi-Fi driver (chipset NXP 88W8987)
KERNEL_MODULE_AUTOLOAD += "moal"
KERNEL_MODULE_PROBECONF += "moal"
module_conf_moal = "options moal mod_para=nxp/wifi_mod_para.conf"

# support to build dtbo
KERNEL_DTC_FLAGS = "-@"
KERNEL_DEVICETREE_OVERLAY ?= ""

do_compile_prepend() {
    if [ -n "${KERNEL_DTC_FLAGS}" ]; then
       export DTC_FLAGS="${KERNEL_DTC_FLAGS}"
    fi
}

do_compile_append() {
    for dtbf in ${KERNEL_DEVICETREE_OVERLAY}; do
        dtb=`normalize_dtb "$dtbf"`
        oe_runmake $dtb CC="${KERNEL_CC} $cc_extra " LD="${KERNEL_LD}" ${KERNEL_EXTRA_ARGS}
    done
}

do_deploy_append(){
   install -d ${DEPLOYDIR}/overlays
   cp ${B}/arch/arm64/boot/dts/renesas/overlays/* ${DEPLOYDIR}/overlays
}
