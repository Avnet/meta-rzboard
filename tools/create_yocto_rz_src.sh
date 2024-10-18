#!/bin/bash

VERSION=0.4.2

# Make sure that the following packages have been downloaded from the official website
# RZ/V Verified Linux Package [5.10-CIP]  V3.0.6
REN_LINUX_BSP_PKG="RTK0EF0045Z0024AZJ-v3.0.6"
SUFFIX_ZIP=".zip"

# RZ MPU Graphics Library V1.2.2 Unrestricted Version
REN_GPU_MALI_LIB_PKG="RTK0EF0045Z14001ZJ-v1.2.2_rzv_EN"
# RZ MPU Graphics Library Evaluation Version V1.2.2
REN_GPU_MALI_LIB_PKG_EVAL="RTK0EF0045Z13001ZJ-v1.2.2_EN"

# RZ MPU Video Codec Library V1.2.2 Unrestricted Version
REN_VIDEO_CODEC_LIB_PKG="RTK0EF0045Z16001ZJ-v1.2.2_rzv_EN"
# RZ MPU Video Codec Library Evaluation Version V1.2.2
REN_VIDEO_CODEC_LIB_PKG_EVAL="RTK0EF0045Z15001ZJ-v1.2.2_EN"

# RZ/V2L DRP-AI Support Package Version 7.50
REN_V2L_DRPAI_PKG="r11an0549ej0750-rzv2l-drpai-sp"

# RZ/V2L Multi-OS Package V2.1.0
REN_V2L_MULTI_OS_PKG="r01an7254ej0210_rzv-multi-os-pkg"
# ----------------------------------------------------------------

WORKSPACE=$(pwd)
YOCTO_HOME="${WORKSPACE}/yocto_rzboard"

function main_process(){
	if [ ! -d "${YOCTO_HOME}" ];then
		mkdir -p "${YOCTO_HOME}"
	fi

	echo "Establishing Yocto environment for RZBoard V2L. Script version: ${VERSION}"
	echo "If any error occurs please:"
	echo "  1) check package versions for accuracy,"
	echo "  2) check git branch for compatibility,"
	echo "  3) Ensure prerequisites sw/libs are met. See meta-rzboard README for details."
	echo "  4) Rerun the script."
	
	set -ex
	check_pkg_require
	unpack_bsp
	unpack_gpu
	unpack_codec
	unpack_drpai
	unpack_multi_os
	remove_redundant_patches
	clone_meta_rzboard
	setup_build_and_patch
	set +ex
}

log_error(){
    local string=$1
    echo -ne "\e[1;31m $string \e[0m\n"
}

log_warn(){
    local string=$1
    echo -ne "\e[1;33m $string \e[0m\n"
}

check_pkg_require(){
	# check required pacakages are downloaded from Renesas website
	local check=0
	cd "${WORKSPACE}"

	if [ ! -e ${REN_LINUX_BSP_PKG}${SUFFIX_ZIP} ];then
		log_error "Error: Cannot found ${REN_LINUX_BSP_PKG}${SUFFIX_ZIP} !"
		log_error "Please download 'RZ/V Verified Linux Package' from Renesas RZ/V2L Website"
		echo ""
		check=1
	fi
	if [ ! -e ${REN_GPU_MALI_LIB_PKG}${SUFFIX_ZIP} ] && [ ! -e ${REN_GPU_MALI_LIB_PKG_EVAL}${SUFFIX_ZIP} ]; then
		log_error "Error: Cannot found ${REN_GPU_MALI_LIB_PKG}${SUFFIX_ZIP} !"
		log_error "Please download 'RZ MPU Graphics Library' from Renesas RZ/V2L Website"
		echo ""
		check=2
	elif [ ! -e ${REN_GPU_MALI_LIB_PKG}${SUFFIX_ZIP} ] && [ -e ${REN_GPU_MALI_LIB_PKG_EVAL}${SUFFIX_ZIP} ]; then
		log_warn "This is an Evaluation Version package ${REN_GPU_MALI_LIB_PKG_EVAL}${SUFFIX_ZIP}"
		log_warn "It is recommended to download 'MPU Graphics Library Unrestricted Version' from Renesas Website"
		echo ""
	fi
	if [ ! -e ${REN_VIDEO_CODEC_LIB_PKG}${SUFFIX_ZIP} ] && [ ! -e ${REN_VIDEO_CODEC_LIB_PKG_EVAL}${SUFFIX_ZIP} ] ;then
		log_error "Error: Cannot found ${REN_VIDEO_CODEC_LIB_PKG}${SUFFIX_ZIP} !"
		log_error "Please download 'RZ MPU Codec Library' from Renesas RZ/V2L Website"
		echo ""
		check=3
	elif [ ! -e ${REN_VIDEO_CODEC_LIB_PKG}${SUFFIX_ZIP} ] && [ -e ${REN_VIDEO_CODEC_LIB_PKG_EVAL}${SUFFIX_ZIP}  ]; then
		log_warn "This is an Evaluation Version package ${REN_VIDEO_CODEC_LIB_PKG_EVAL}${SUFFIX_ZIP}"
		log_warn "It is recommended to download 'MPU Video Codec Library Unrestricted Version' from Renesas Website"
		echo ""
	fi   
	if [ ! -e ${REN_V2L_DRPAI_PKG}${SUFFIX_ZIP} ];then
		log_error "Error: Cannot found ${REN_V2L_DRPAI_PKG}${SUFFIX_ZIP} !"
		log_error "Please download 'RZ/V2L DRP-AI Support Package' from Renesas RZ/V2L Website"
		echo ""
		check=4
	fi
	if [ ! -e ${REN_V2L_MULTI_OS_PKG}${SUFFIX_ZIP} ];then
		log_error "Error: Cannot found ${REN_V2L_MULTI_OS_PKG}${SUFFIX_ZIP} !"
		log_error "Please download 'RZ/V2L Group Multi-OS Package' from Renesas RZ/V2L Website"
		echo ""
		check=6
	fi

	[ ${check} -ne 0 ] && echo "---Failed---" && exit
}

# usage: extract_to_meta zipfile zipdir tarfile tardir
function extract_to_meta(){
	local zipfile=$1
	local zipdir=$2
	local tarfile_tmp=$3
	local tardir=$4
	local tarfile=

	echo ""
	echo "$zipfile $zipdir"
	echo "$tarfile_tmp $tardir"

	cd "${WORKSPACE}"
	pwd
	echo "Extract zip file to ${zipdir} and then untar ${tarfile_tmp} file"
	unzip -d "${zipdir}" "${zipfile}"
	tarfile=$(find "${zipdir}" -type f -name "${tarfile_tmp}")
	echo "TAR: \"${tarfile}\""
	tar -xzf "${tarfile}" -C "${tardir}"
	sync
}

function unpack_bsp(){
	local pkg_file=${WORKSPACE}/${REN_LINUX_BSP_PKG}${SUFFIX_ZIP}
	local zip_dir="REN_LINUX_BSP"
	local bsp="rzv*_v*.tar.gz"
	local bsp_patch=""

	extract_to_meta "$pkg_file" "$zip_dir" "$bsp" "$YOCTO_HOME"
	bsp_patch=$(find "${zip_dir}" -type f -name "rzv*.patch")
	if [ -n "${bsp_patch}" ]; then
		echo "${bsp_patch}"
		patch -d "${YOCTO_HOME}" -p1 < "${bsp_patch}"
	fi
	rm -fr "${zip_dir}"
}

function unpack_gpu(){
	local pkg_file=${WORKSPACE}/${REN_GPU_MALI_LIB_PKG}${SUFFIX_ZIP}
	local zip_dir="REN_GPU_MALI"
	local gpu="meta-rz*_v*.tar.gz"

	if [ ! -e ${REN_GPU_MALI_LIB_PKG}${SUFFIX_ZIP} ]; then
		pkg_file=${WORKSPACE}/${REN_GPU_MALI_LIB_PKG_EVAL}${SUFFIX_ZIP}
	fi

	extract_to_meta "${pkg_file}" "${zip_dir}" "${gpu}" "${YOCTO_HOME}"
	rm -fr "${zip_dir}"
}

function unpack_codec(){
	local pkg_file=${WORKSPACE}/${REN_VIDEO_CODEC_LIB_PKG}${SUFFIX_ZIP}
	local zip_dir="REN_VIDEO_CODEC"
	local codec="meta-rz*_v*.tar.gz"

	if [ ! -e ${REN_VIDEO_CODEC_LIB_PKG}${SUFFIX_ZIP} ]; then
		pkg_file=${WORKSPACE}/${REN_VIDEO_CODEC_LIB_PKG_EVAL}${SUFFIX_ZIP}
	fi

	extract_to_meta "${pkg_file}" "${zip_dir}" "${codec}" "${YOCTO_HOME}"
	rm -fr ${zip_dir}
}

function unpack_drpai(){
	local pkg_file=${WORKSPACE}/${REN_V2L_DRPAI_PKG}${SUFFIX_ZIP}
	local zip_dir="REN_V2L_DRPAI"
	local drpai="meta-rz*.tar.gz"

	extract_to_meta "${pkg_file}" "${zip_dir}" "${drpai}" "${YOCTO_HOME}"
	rm -fr ${zip_dir}
}

function unpack_multi_os(){
	local pkg_file=${WORKSPACE}/${REN_V2L_MULTI_OS_PKG}${SUFFIX_ZIP}
	local zip_dir="REN_MULTI_OS"
	local rtos="meta-rz*.tar.gz"

	extract_to_meta "${pkg_file}" "${zip_dir}" "${rtos}" "${YOCTO_HOME}"
	rm -fr ${zip_dir}
}

function remove_redundant_patches(){
	# remove linux patches that were merged into the Avnet kernel
	flist=$(find "${YOCTO_HOME}" -name "linux-renesas_*.bbappend")
	for ff in ${flist}
	do
		echo "${ff}"
		rm -rf "${ff}"
	done

	# remove u-boot patches
	find "${YOCTO_HOME}" -name "u-boot_*.bbappend" -print -exec rm -rf {} \;

	# remove tfa patches
	find "${YOCTO_HOME}" -name "trusted-firmware-a.bbappend" -print -exec mv {} {}.remove \;
}

function clone_meta_rzboard(){
	git clone https://github.com/Avnet/meta-rzboard.git -b rzboard_dunfell_5.10.201
	mv meta-rzboard "${YOCTO_HOME}"

}

function setup_build_and_patch(){
	cd "${YOCTO_HOME}"

	echo "Creating build folder with suitable configuration"
	mkdir -p ./build/conf
	cp meta-rzboard/conf/rzboard/* build/conf/

	echo "ls ./build/conf"
	ls ./build/conf

	echo "Patching some meta layers to support Node 18"
	cp meta-rzboard/RZV2L_VLP306_switch_to_nodejs_18.17.1.patch .
	patch -p1 < ./RZV2L_VLP306_switch_to_nodejs_18.17.1.patch

	echo "Build environment established. Please refer to the README.md for build instructions."
	echo "For a quickstart, 'source poky/oe-init-build-env' then run 'bitbake rzboard-image'."
}

#---start--------
main_process "$*"
exit
