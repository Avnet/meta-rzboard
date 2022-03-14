
SRCREV = "49e2ee45b7a2ebdbdebe7528f916afb6fd13846a"

do_compile() {
	PMIC_BOARD="RZV2L_SMARC_PMIC";

	cd ${S}

	oe_runmake OUTPUT_DIR=${PMIC_BUILD_DIR} clean;
	oe_runmake BOARD=${PMIC_BOARD} OUTPUT_DIR=${PMIC_BUILD_DIR};
	mv ${PMIC_BUILD_DIR}/Flash_Writer_SCIF_RZV2L_SMARC_PMIC_DDR4_2GB_1PCS.mot ${PMIC_BUILD_DIR}/flashwriter_${MACHINE}.mot
}

do_deploy() {
	install -m 755 ${PMIC_BUILD_DIR}/flashwriter_${MACHINE}.mot ${DEPLOYDIR}
}
