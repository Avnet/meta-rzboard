SUMMARY = "Flash Writer for RzBoard"

BOARD ?= ""
BOARD_rzboard = "RZV2L_SMARC_PMIC"

do_compile_append_rzboard() {
	mv ${S}/AArch64_output/Flash_Writer*${BOARD}*.mot ${S}/AArch64_output/Flash_Writer_SCIF_${MACHINE}.mot
}
