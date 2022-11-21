# meta-rzboard

This is a meta-layer for Avnet RzBoard.

- Yocto dunfell 3.1.14 support:  Avnet RzBoard



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

Due to licensing restrictions on the Renesas website, users are required to download the software packages from the [Official RZ/V2L Website](https://www.renesas.cn/us/en/products/microcontrollers-microprocessors/rz-mpus/rzv2l-general-purpose-microprocessor-equipped-renesas-original-ai-accelerator-drp-ai-12ghz-dual) in person.

The following packages should be download:

| Package Name                  | Version                  | Download File                               |
| ----------------------------- | ------------------------ | ------------------------------------------- |
| RZ/V Verified Linux Package   | v3.0.0-update2           | RTK0EF0045Z0024AZJ-v3.0.0-update2.zip       |
| RZ MPU Graphics Library       | Evaluation Version V1.2  | RTK0EF0045Z13001ZJ-v1.21_EN.zip             |
| RZ MPU Codec Library          | Evaluation Version V0.58 | RTK0EF0045Z15001ZJ-v0.58_EN.zip             |
| RZ/V2L DRP-AI Support Package | V7.20                    | r11an0549ej0720-rzv2l-drpai-sp.zip          |
| RZ/V2L ISP Support Package    | V1.20                    | r11an0561ej0120-rzv2l-isp-sp.zip            |
| RZ/V2L Multi-OS Package       | V1.02                    | r01an6238ej0102-rzv2l-cm33-multi-os-pkg.zip |

*Note: The evaluation versions contain a time limitation that stops the software after a few hours.*

For more information please refer to [RZ/V2L Wiki](https://renesas.info/wiki/RZ-V/RZ-V2L_SMARC).



After getting all the packages, copy them to **the home directory ( ~/ )** and prepare for the next step.



* ##### **Extract Renesas software packages**

Download a script to extract the file
```bash
$ cd ~/
$ wget http://192.168.2.100/renesas/meta-rzboard/-/blob/rzboard_dunfell_5.10/tools/create_yocto_rz_src.sh
$ ls ~/
create_yocto_rz_src.sh                       RTK0EF0045Z0024AZJ-v3.0.0-update2.zip
r01an6238ej0102-rzv2l-cm33-multi-os-pkg.zip  RTK0EF0045Z13001ZJ-v1.21_EN.zip
r11an0549ej0720-rzv2l-drpai-sp.zip           RTK0EF0045Z15001ZJ-v0.58_EN.zip
r11an0561ej0120-rzv2l-isp-sp.zip
```
Run the script to generate **yocto_rzboard/** directory
```bash
$ ./create_yocto_rz_src.sh
$ ls yocto_rzboard/
meta-gplv2     meta-openembedded  meta-renesas      meta-virtualization
meta-multi-os  meta-qt5           meta-rz-features  poky
```



* ##### **Download meta-rzboard**

```bash
$ cd ~/yocto_rzboard
$ git clone https://github.com/Avnet/meta-rzboard.git -b rzboard_dunfell_5.10
```

So far, all the yocto related sources are in place.

```bash
$ ls ~/yocto_rzboard
meta-gplv2     meta-openembedded  meta-renesas  meta-rz-features     poky
meta-multi-os  meta-qt5           meta-rzboard  meta-virtualization
```



### Build a image

*  ##### **Create build configuration**

```bash
$ cd ~/yocto_rzboard
$ mkdir -p ~/yocto_rzboard/build/conf
$ cp meta-rzboard/conf/rzboard/* build/conf/
$ ls build/conf/
bblayers.conf  local.conf
```

*  ##### **Build**
```bash
$ cd ~/yocto_rzboard/
$ source poky/oe-init-build-env build/
$ bitbake core-image
```
After the build is successfully completed, the output files will be located in build/tmp/deploy/images/rzboard/ directory.
