LIC_FILES_CHKSUM = "file://docs/license.rst;md5=713afe122abbe07f067f939ca3c480c5"

COMPATIBLE_MACHINE = "(smarc-rzg2l|rzg2l-dev|smarc-rzv2l|rzv2l-dev|rzboard)"

URL = "${RZBOARD_GIT_HOST_MIRROR}/trusted-firmware-a.git"
BRANCH = "rzboard_v2l"
SRCREV = "05f419dbb35cf01583295722fcda37e78bbb6259"

SRC_URI += "${URL};${RZBOARD_GIT_PROTOCOL};branch=${BRANCH};${RZBOARD_GIT_USER}"

PV = "2.5-rzg+git${SRCPV}"
PR = "r1"
SECTION = "bootloaders"
SUMMARY = "Trusted Firmware-A for RZ/G2L and RZ/V2L"
LICENSE = "BSD-3-Clause"


inherit deploy

S = "${WORKDIR}/git"

PLATFORM_rzboard = "v2l"
EXTRA_FLAGS_rzboard = "BOARD=rzboard"
FLASH_ADDRESS_BL2_BP_rzboard = "00000"
FLASH_ADDRESS_FIP_rzboard = "1D200"

# Requires CROSS_COMPILE set by hand as there is no configure script
export CROSS_COMPILE="${TARGET_PREFIX}"

# Let the Makefile handle setting up the CFLAGS and LDFLAGS as it is a standalone application
CFLAGS[unexport] = "1"
LDFLAGS[unexport] = "1"
AS[unexport] = "1"
LD[unexport] = "1"

# No configure
do_configure[noexec] = "1"

FILES_${PN} = "/boot "
SYSROOT_DIRS += "/boot"

do_compile () {
	# Build TF-A
	oe_runmake PLAT=${PLATFORM} ${EXTRA_FLAGS} bl2 bl31
}

do_install () { 
	install -d ${D}/boot 
	install -m 755 ${S}/build/${PLATFORM}/release/bl2.bin ${D}/boot/bl2-${MACHINE}.bin
	install -m 755 ${S}/build/${PLATFORM}/release/bl31.bin ${D}/boot/bl31-${MACHINE}.bin
}

do_deploy () {
	# Create deploy folder
	install -d ${DEPLOYDIR}

	# Copy IPL
	install -m 0644 ${S}/build/${PLATFORM}/release/bl2.bin ${DEPLOYDIR}/bl2-${MACHINE}.bin
	install -m 0644 ${S}/build/${PLATFORM}/release/bl31.bin ${DEPLOYDIR}/bl31-${MACHINE}.bin
}

addtask deploy before do_build after do_compile
