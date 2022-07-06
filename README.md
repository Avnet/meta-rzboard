This README file contains information on the contents of the meta-rzboard layer. Please see the corresponding sections below for details.



# 1. About meta-rzboard

This is a Yocto build layer( version: 3.1.5 dunfell ) that provides support for the RzBoard from Avnet, which is based on RZ/V2L Group of 64bit Arm-based MPUs from Renesas Electronics. Currently the following boards and MPUs are supported:

- Board: Avnet RzBoard



# 2. Building Instruction



## 2.1 Ubuntu Host Preparation



Ubuntu should be used as the Linux Host PC OS since the Yocto Project Quick Start specifies Ubuntu as one of the supported distributions. In that case, you can install the required packages by using the commands below.

```bash
$ sudo apt-get update
$ sudo apt-get install -y wget git-core diffstat unzip texinfo gcc-multilib \
build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa \
libsdl1.2-dev pylint3 xterm rsync curl locales bash-completion
```



## 2.2  Fetch Yocto Source code



* **Create working directory**

```bash
$ mkdir ~/yocto_rzboard
$ cd ~/yocto_rzboard
```

* **Download Poky source code**

```bash
$ git clone https://git.yoctoproject.org/git/poky
$ cd poky
$ git checkout dunfell-23.0.5
$ git cherry-pick 9e44438a9deb7b6bfac3f82f31a1a7ad138a5d16
$ cd ../
```

* **Download meta-openembedded**

```bash
$ git clone https://github.com/openembedded/meta-openembedded
$ cd meta-openembedded
$ git checkout cc6fc6b1641ab23089c1e3bba11e0c6394f0867c
$ cd ../
```

- **Download meta-gplv2**

```bash
$ git clone https://git.yoctoproject.org/git/meta-gplv2 -b dunfell
$ cd meta-gplv2
$ git checkout 60b251c25ba87e946a0ca4cdc8d17b1cb09292ac
$ cd ../
```

* **Download meta-renesas**

```bash
$ git clone https://github.com/Avnet/meta-renesas.git -b dunfell_rzv2l_bsp_v100
```

* **Download meta-rzboard**

```bash
$ git clone https://github.com/Avnet/meta-rzboard.git -b rzboard_dunfell
```


Now,  the all Yocto related sources are already prepared:

```bash
$ ls ~/yocto_rzboard
meta-gplv2  meta-openembedded  meta-renesas  meta-rzboard  poky
```



## 2.3 Build BSP using Yocto



*  **Edit build configuration**

```bash
$ cd ~/yocto_rzboard
$ mkdir -p ~/yocto_rzboard/build/conf
$ cp meta-rzboard/conf/rzboard/* build/conf/
$ ls build/conf/
bblayers.conf  local.conf
```

Users can edit the file ***bblayers.conf, local.conf***  for their own purpose. If you want to change the git
repository address and account information for RzBoard, please set as below in **conf/local.conf** :

```bash
RZBOARD_GIT_HOST_MIRROR = "git://your_url"
RZBOARD_GIT_PROTOCOL = "protocol=http"
RZBOARD_GIT_USER = "user=username:password"
```

And user can specify the download directory which store all the packages of yocto, set in **conf/local.conf** :

```bash
DL_DIR ?= "${HOME}/downloads"
```



*  **Setting build environment and Build**

```bash
$ cd ~/yocto_rzboard/
$ source poky/oe-init-build-env build/
$ bitbake core-image
```

After building, the output files are deployed in ***tmp/deploy/images/rzboard/*** :

* **flashwriter_rzboard.mot** : Flash Writer

* **bl2_bp-rzboard.srec** : BL2 S-record file.
* **fip-rzboard.srec** : BL31 and U-boot package in S-record format
* **core-image-rzboard-xxxx.rootfs.wic** : SD Card system image, include linux kernel, DTB and root filesystem.
* **Image** : kernel image
* **rzboard.dtb** : RzBoard device tree binary
* **roverlays/rzboard-*.dtbo** : RzBoard device tree overlay binary
* **core-image-rzboard-xxxx.rootfs.tar.bz2** : root filesystem

