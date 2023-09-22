# meta-rzboard

This is a meta-layer for Avnet RzBoard.

- Yocto dunfell 3.1.21 support:  Avnet RzBoard



## How to Build


### Build environment

It is recommended to setup the development environment on a *<font color=red>64-bit Ubuntu 20.04 LTS</font>* machine.
The following packages are required:

```bash
$ sudo apt update
$ sudo apt install -y gawk wget git-core diffstat unzip texinfo gcc-multilib \
build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
xz-utils debianutils iputils-ping libsdl1.2-dev xterm p7zip-full libyaml-dev \
rsync curl locales bash-completion
```

Set Git configuration:

```bash
$ git config --global user.name "Your Name"
$ git config --global user.email "you@example.com"
```



### Fetch the source code

* ##### **Download Renesas software packages**

Due to licensing restrictions on the Renesas website, users are required to download the software packages from the [Official RZ/V2L Website](https://www.renesas.com/us/en/products/microcontrollers-microprocessors/rz-mpus/rzv2l-general-purpose-microprocessor-equipped-renesas-original-ai-accelerator-drp-ai-12ghz-dual) in person.

The following packages should be download:

| Package Name                  | Version                    | Download File                               |
| ----------------------------- | -------------------------- | ------------------------------------------- |
| RZ/V Verified Linux Package   | V3.0.4            | [RTK0EF0045Z0024AZJ-v3.0.4.zip](https://www.renesas.com/us/en/document/swo/rzv-verified-linux-package-v304rtk0ef0045z0024azj-v304zip?r=1628526) |
| RZ MPU Graphics Library       | Evaluation Version V1.1.0 | [RTK0EF0045Z13001ZJ-v1.1.0_EN.zip](https://www.renesas.com/us/en/document/sws/rz-mpu-graphics-library-evaluation-version-rzv2l-rtk0ef0045z13001zj-v110enzip?r=1843541) |
| RZ MPU Codec Library          | Evaluation Version V1.1.0 | [RTK0EF0045Z15001ZJ-v1.1.0_EN.zip](https://www.renesas.com/us/en/document/sws/rz-mpu-video-codec-library-evaluation-version-rzv2l-rtk0ef0045z15001zj-v110enzip?r=1844066) |
| RZ/V2L DRP-AI Support Package | V7.40                      | [r11an0549ej0740-rzv2l-drpai-sp.zip](https://www.renesas.com/us/en/document/sws/rzv2l-drp-ai-support-package-version-740?r=1558356) |
| RZ/V2L Multi-OS Package       | V1.11                      | [r01an6238ej0111-rzv2l-cm33-multi-os-pkg.zip](https://www.renesas.com/us/en/document/sws/rzv-multi-os-package-v111?r=1570181) |

> ***Note***: 
> *1  The Renesas website provides two version packages, "**Evaluation Version**" and "**Unrestricted Version**", for each of the RZ MPU Graphics Library and the RZ MPU Codec Library.*
> *2  The "**Evaluation Version**" can be downloaded immediately, but has a 2 hour timeout after every board boot.*
> *3  The "**Unrestricted Versions**"  is not available for download until the request for permission on the Renesas website is complete.*


For more information please refer to [RZ/V2L Wiki](https://renesas.info/wiki/RZ-V/RZ-V2L_SMARC) and [RZ/V2 Linux BSP](https://renesas.info/wiki/RZ-G/RZ-G2_BSP).



After getting all the packages, copy them to **the home directory ( ~/ )** and prepare for the next step.

* ##### **Extract Renesas software packages**

Download a script to extract the file
```bash
$ cd ~/
$ wget https://raw.githubusercontent.com/Avnet/meta-rzboard/rzboard_dunfell_5.10_v3/tools/create_yocto_rz_src.sh
$ chmod a+x create_yocto_rz_src.sh
$ ls ~/
create_yocto_rz_src.sh                       RTK0EF0045Z0024AZJ-v3.0.4.zip
r01an6238ej0111-rzv2l-cm33-multi-os-pkg.zip  RTK0EF0045Z13001ZJ-v1.1.0_EN.zip
r11an0549ej0740-rzv2l-drpai-sp.zip           RTK0EF0045Z15001ZJ-v1.1.0_EN.zip
```
Run the script to generate **yocto_rzboard/** directory
```bash
$ ./create_yocto_rz_src.sh
$ ls yocto_rzboard/
meta-gplv2         meta-qt5      meta-rz-features     poky
meta-openembedded  meta-renesas  meta-virtualization      
```



* ##### **Download meta-rzboard**

```bash
$ cd ~/yocto_rzboard
$ git clone https://github.com/Avnet/meta-rzboard.git -b rzboard_dunfell_5.10_v3
```

So far, all the yocto related sources are in place.

```bash
$ ls ~/yocto_rzboard
meta-gplv2         meta-qt5      meta-rz-features  meta-virtualization
meta-openembedded  meta-renesas  meta-rzboard      poky
```



### Build a image

*  ##### **Create build configuration**

```bash
$ cd ~/yocto_rzboard
$ mkdir -p ./build/conf
$ cp meta-rzboard/conf/rzboard/* build/conf/
$ ls build/conf/
bblayers.conf  local.conf
```

*  ##### **Build**
```bash
$ cd ~/yocto_rzboard/
$ source poky/oe-init-build-env build/
$ bitbake avnet-core-image
```
After the build is successfully completed, the output files will be located in build/tmp/deploy/images/rzboard/ directory.

For more information about Edge Impulse, including installing Edge Impulse Linux CLI, please refer to [the link](https://docs.edgeimpulse.com/docs/development-platforms/officially-supported-cpu-gpu-targets/renesas-rz-v2l).
