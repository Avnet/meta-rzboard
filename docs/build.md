# 1.1 Setup Build Environment

To setup the build environment the following resources are required:

* Hardware: At least 300GB of disk space and 8GB of RAM

* Software: Ubuntu 64-bit OS, 20.04 LTS version (Ubuntu Desktop or Ubuntu Server version).

    You could also run the Ubuntu 64-bit OS on virtual machine or in docker container.

The following packages are required for the development environment.  They can be installed running the following commands:

```bash
sudo apt-get update
sudo apt install -y gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat cpio python python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping libsdl1.2-dev xterm p7zip-full libyaml-dev rsync curl locales bash-completion
```

# 1.2 Fetch Source Code

## 1.2.1 Download Renesas Software Packages

Download the following packages from the Renesas Website:

| # | Package Name | Version | File | URL |
|---|---|---|---|---|
|1| RZ/V Verified Linux Package | v3.0.0-update2 | RTK0EF0045Z0024AZJ-v3.0.0-update2.zip | https://www.renesas.com/us/en/document/sws/rzv-verified-linux-package-v300-update2rtk0ef0045z0024azj-v300-update2zip |
| 2 | RZ MPU Graphics Library | Evaluation Version V1.2 | RTK0EF0045Z13001ZJ-v1.21_EN.zip | https://www.renesas.com/sg/en/document/sws/rz-mpu-graphics-library-evaluation-version-v121-rzg2l-rzg2lc-and-rzv2l-rtk0ef0045z13001zj-v121enzip |
| 3 | RZ MPU Codec Library | Evaluation Version V0.58 | RTK0EF0045Z15001ZJ-v0.58_EN.zip | https://www.renesas.com/us/en/document/sws/rz-mpu-video-codec-library-evaluation-version-v058-rzg2l-and-rzv2l-rtk0ef0045z15001zj-v058enzip |
| 4 | RZ/V2L DRP-AI Support Package | V7.20 | r11an0549ej0720-rzv2l-drpai-sp.zip | https://www.renesas.com/sg/en/document/sws/rzv2l-drp-ai-support-package-version-720?r=1558356 |
| 5 | RZ/V2L ISP Support Package | V1.20 | r11an0561ej0120-rzv2l-isp-sp.zip | https://www.renesas.com/us/en/document/sws/rzv2l-isp-support-package-version-120 |
| 6 | RZ/V2L Multi-OS Package | V1.02 | r01an6238ej0102-rzv2l-cm33-multi-os-pkg.zip | https://www.renesas.com/us/en/document/sws/rzv2l-multi-os-package-v102?r=1570181 |

After downloading these packages, copy them to the **home directory `~/`**.

**Note:** The “Evaluation” packages contain a time limitation that stops the software after a few hours.
For more information please refer to [RZ/V2L Wiki](https://renesas.info/wiki/RZ-V/RZ-V2L_SMARC).

## 1.2.2 Extract Renesas Software Packages

Download support extraction script:
```bash
cd ~
wget https://raw.githubusercontent.com/Avnet/metarzboard/rzboard_dunfell_5.10/tools/create_yocto_rz_src.sh
chmod +x create_yocto_rz_src.sh
./create_yocto_rz_src.sh
```

## 1.2.3 Download RZ Board Meta Layer
```bash
cd ~/yocto_rzboard
git clone https://github.com/Avnet/meta-rzboard.git -b rzboard_dunfell_5.10
```

# 1.3 Yocto Build

## 1.3.1 Configure Build Environment
Create a build area and copy RZBoard configs to the build area:

```
cd ~/yocto_rzboard
mkdir -p ~/yocto_rzboard/build/conf
cp meta-rzboard/conf/rzboard/* build/conf
```

It's recommended to set a downloads directory to save time during clean builds.  To do this, edit `~/yocto_rzboard/build/conf/local.conf` with the following line:

```bash
DL_DIR ?= "${HOME}/downloads"
```

The value of `DL_DIR` can be changed to your desired downloads directory (e.g. an NFS mount).

## 1.3.2 Build

```bash
cd ~/yocto_rzboard
source poky/oe-init-build-env build
bitbake avnet-core-image
```

After the build has successfully completed, the output files are deployed in:
`~/yocto_rzboard/build/tmp/deploy/images/rzboard/`

|File|Description|
|-|-|
|flashwriter_rzboard.mot | FlashWriter image too
|bl2_bp-rzboard.srec | BL2 bootloader file in S-record format |
| fip-rzboard.srec | BL31 bootloader plus u-Boot packages in S-record format |
| avnet-core-image-rzboardxxxx.rootfs.wic | System image, this includes: Linux kernel, DTB and root file system. |
| Image | Kernel image |
| rzboard.dtb | RZBoard device tree binary |
| overlays/rzboard-*.dtbo | RZBoard device tree overlay binary |
| avnet-core-image-rzboardxxxx.rootfs.tar.bz2 | System image compressed archive file |