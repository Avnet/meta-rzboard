#!/bin/bash

VERSION=0.1.0

# Make sure that the following packages have been downloaded from the official website
# RZ/V Verified Linux Package [5.10-CIP]  V3.0.0-update2
REN_LINUX_BSP_PKG="RTK0EF0045Z0024AZJ-v3.0.0-update2"
SUFFIX_ZIP=".zip"

# RZ MPU Graphics Library Evaluation Version V1.2
REN_GPU_MALI_LIB_PKG="RTK0EF0045Z13001ZJ-v1.21_EN"

# RZ MPU Codec Library Evaluation Version V0.58
REN_VEDIO_CODEC_LIB_PKG="RTK0EF0045Z15001ZJ-v0.58_EN"

# RZ/V2L DRP-AI Support Package Version 7.20
REN_V2L_DRPAI_PKG="r11an0549ej0720-rzv2l-drpai-sp"

# RZ/V2L ISP Support Package Version 1.20
REN_V2L_ISP_PKG="r11an0561ej0120-rzv2l-isp-sp"

# RZ/V2L Multi-OS Package V1.02
REN_V2L_MULTI_OS_PKG="r01an6238ej0102-rzv2l-cm33-multi-os-pkg"  
                   
# ----------------------------------------------------------------

WORKSPACE=$(pwd)
YOCTO_HOME="${WORKSPACE}/yocto_rzboard"

function main_process(){
	if [ ! -d ${YOCTO_HOME} ];then
		mkdir -p ${YOCTO_HOME}
	fi

	check_pkg_require
	unpack_bsp
	unpack_gpu
	unpack_codec
	unpack_drpai
	unpack_isp
	unpack_multi_os
	remove_redundant_patches
	ls ${YOCTO_HOME}
	echo ""
	echo "---Finished---"
}

log_error(){
    local string=$1
    echo -ne "\e[31m $string \e[0m\n"
}

check_pkg_require(){
	# check required pacakages are downloaded from Renesas website
	local check=0
	cd ${WORKSPACE}

	if [ ! -e ${REN_LINUX_BSP_PKG}${SUFFIX_ZIP} ];then
		log_error "Cannot found ${REN_LINUX_BSP_PKG}${SUFFIX_ZIP} !"
		echo "Please download 'RZ/V Verified Linux Package' from Renesas RZ/V2L Website"
		check=1
	fi
	if [ ! -e ${REN_GPU_MALI_LIB_PKG}${SUFFIX_ZIP} ];then
		log_error "Cannot found ${REN_GPU_MALI_LIB_PKG}${SUFFIX_ZIP} !"
		echo "Please download 'RZ MPU Graphics Library' from Renesas RZ/V2L Website"
		check=2
	fi
	if [ ! -e ${REN_VEDIO_CODEC_LIB_PKG}${SUFFIX_ZIP} ];then
		log_error "Cannot found ${REN_VEDIO_CODEC_LIB_PKG}${SUFFIX_ZIP} !"
		echo "Please download 'RZ MPU Codec Library' from Renesas RZ/V2L Website"
		check=3
	fi   
	if [ ! -e ${REN_V2L_DRPAI_PKG}${SUFFIX_ZIP} ];then
		log_error "Cannot found ${REN_V2L_DRPAI_PKG}${SUFFIX_ZIP} !"
		echo "Please download 'RZ/V2L DRP-AI Support Package' from Renesas RZ/V2L Website"
		check=4
	fi
	if [ ! -e ${REN_V2L_ISP_PKG}${SUFFIX_ZIP} ];then
		log_error "Cannot found ${REN_V2L_ISP_PKG}${SUFFIX_ZIP} !"
		echo "Please download 'RZ/V2L ISP Support Package' from Renesas RZ/V2L Website"
		check=5
	fi
	if [ ! -e ${REN_V2L_MULTI_OS_PKG}${SUFFIX_ZIP} ];then
		log_error "Cannot found ${REN_V2L_MULTI_OS_PKG}${SUFFIX_ZIP} !"
		echo "Please download 'RZ/V2L Group Multi-OS Package' from Renesas RZ/V2L Website"
		check=6
	fi

	[ ${check} -ne 0 ] && echo "---Failed---" && exit
}

function extract_to_meta(){
	local zipfile=$1
	local tarfile=$2
	local tardir=$3
	
	cd ${WORKSPACE}
	pwd
	unzip ${zipfile}
	tar -xzf ${tarfile} -C ${tardir}
	sync
}

function unpack_bsp(){
	local pkg_file=${WORKSPACE}/${REN_LINUX_BSP_PKG}${SUFFIX_ZIP}
	local zip_dir=${REN_LINUX_BSP_PKG}

	local bsp="rzv_bsp_v3.0.0.tar.gz"
	local bsp_patch="rzv_v300-to-v300update2.patch"

	extract_to_meta ${pkg_file} "${zip_dir}/${bsp}" ${YOCTO_HOME}
	patch -d ${YOCTO_HOME} -p1 < ${zip_dir}/${bsp_patch}
	rm -fr ${zip_dir}
}

function unpack_gpu(){
	local pkg_file=${WORKSPACE}/${REN_GPU_MALI_LIB_PKG}${SUFFIX_ZIP}
	local zip_dir=${REN_GPU_MALI_LIB_PKG}

	local gpu="meta-rz-features.tar.gz"

	extract_to_meta ${pkg_file} "${zip_dir}/${gpu}" ${YOCTO_HOME}
	rm -fr ${zip_dir}
}

function unpack_codec(){
	local pkg_file=${WORKSPACE}/${REN_VEDIO_CODEC_LIB_PKG}${SUFFIX_ZIP}
	local zip_dir=${REN_VEDIO_CODEC_LIB_PKG}

	local codec="meta-rz-features.tar.gz"

	extract_to_meta ${pkg_file} "${zip_dir}/${codec}" ${YOCTO_HOME}
	rm -fr ${zip_dir}
}

function unpack_drpai(){
	local pkg_file=${WORKSPACE}/${REN_V2L_DRPAI_PKG}${SUFFIX_ZIP}
	local zip_dir=${REN_V2L_DRPAI_PKG}

	local drpai="rzv2l_drpai-driver/meta-rz-features.tar.gz"

	cd ${WORKSPACE}
	unzip -d ${zip_dir} ${pkg_file}
	tar -xzf ${zip_dir}/${drpai} -C ${YOCTO_HOME}
	sync
	rm -fr ${zip_dir}
}

function unpack_isp(){
	local pkg_file=${WORKSPACE}/${REN_V2L_ISP_PKG}${SUFFIX_ZIP}
	local zip_dir=${REN_V2L_ISP_PKG}

	local isp="meta-rz-features.tar.gz"

	extract_to_meta ${pkg_file} "${zip_dir}/${isp}" ${YOCTO_HOME}
	rm -fr ${zip_dir}
}

function unpack_multi_os(){
	local pkg_file=${WORKSPACE}/${REN_V2L_MULTI_OS_PKG}${SUFFIX_ZIP}
	local zip_dir=${REN_V2L_MULTI_OS_PKG}

	local rtos="meta-rz-features.tar.gz"

	extract_to_meta ${pkg_file} "${zip_dir}/${rtos}" ${zip_dir}
	cp -ar ${WORKSPACE}/${zip_dir}/meta-rz-features ${YOCTO_HOME}/meta-multi-os
	rm -fr ${zip_dir}

	# replace the layer name
	sed -i 's/rz-features/multi-os/g' ${YOCTO_HOME}/meta-multi-os/conf/layer.conf
}

function remove_redundant_patches(){
	# remove linux patches that were merged into the Avnet kernel
	flist=$(find ${YOCTO_HOME} -name "linux-renesas_*.bbappend")
	for ff in ${flist}
	do
		echo ${ff}
		rm -rf ${ff}
	done

	# remove u-boot patches
	find ${YOCTO_HOME} -name "u-boot_*.bbappend" -print -exec rm -rf {} \;

	# remove tfa patches
	find ${YOCTO_HOME} -name "trusted-firmware-a.bbappend" -print -exec mv {} {}.remove \;
}

#---start--------
main_process $*
exit
