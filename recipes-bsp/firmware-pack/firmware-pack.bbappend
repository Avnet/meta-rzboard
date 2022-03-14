do_compile () {

	# Create bl2_bp.bin
	bootparameter ${WORKDIR}/recipe-sysroot/boot/bl2-${MACHINE}.bin bl2_bp.bin
	cat ${WORKDIR}/recipe-sysroot/boot/bl2-${MACHINE}.bin >> bl2_bp.bin

	# Create fip.bin
	fiptool create --align 16 --soc-fw ${WORKDIR}/recipe-sysroot/boot/bl31-${MACHINE}.bin --nt-fw ${WORKDIR}/recipe-sysroot/boot/u-boot.bin fip.bin

	# Convert to srec
	objcopy -O srec --adjust-vma=0x00011E00 --srec-forceS3 -I binary bl2_bp.bin bl2_bp.srec
	objcopy -I binary -O srec --adjust-vma=0x0000 --srec-forceS3 fip.bin fip.srec
}

do_deploy () {
	# Create deploy folder
	install -d ${DEPLOYDIR}

	# Copy fip images
	install -m 0755 ${S}/bl2_bp.srec ${DEPLOYDIR}/bl2_bp-${MACHINE}.srec
	install -m 0755 ${S}/fip.srec ${DEPLOYDIR}/fip-${MACHINE}.srec
}

addtask deploy before do_build after do_compile
