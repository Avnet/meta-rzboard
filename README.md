# meta-rzboard

This is a meta-layer for Avnet RzBoard.

- Yocto dunfell 3.1.14 support:  Avnet RzBoard



## How to Build


#### Build environment

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



#### Fetch the source code

* **Create working directory**

```bash
$ mkdir ~/yocto_rzboard
$ cd ~/yocto_rzboard
```

* **Download Poky source code**

```bash
$ git clone https://git.yoctoproject.org/git/poky
$ cd poky
$ git checkout dunfell-23.0.14
$ git cherry-pick 9e44438a9deb7b6bfac3f82f31a1a7ad138a5d16
$ git cherry-pick cfd897e213debb2e32589378b2f5d390a265eb7f
$ cd ../
```

* **Download meta-openembedded**

```bash
$ git clone https://github.com/openembedded/meta-openembedded
$ cd meta-openembedded
$ git checkout ec978232732edbdd875ac367b5a9c04b881f2e19
$ cd ../
```

- **Download meta-gplv2**

```bash
$ git clone https://git.yoctoproject.org/git/meta-gplv2 -b dunfell
$ cd meta-gplv2
$ git checkout 60b251c25ba87e946a0ca4cdc8d17b1cb09292ac
$ cd ../
```

- **Download meta-qt5 and Docker (Optional)**

```bash
$ git clone https://github.com/meta-qt5/meta-qt5.git
$ cd meta-qt5
$ git checkout c1b0c9f546289b1592d7a895640de103723a0305
$ cd ../

$ git clone https://git.yoctoproject.org/git/meta-virtualization -b dunfell
$ cd meta-virtualization
$ git checkout c5f61e547b90aa8058cf816f00902afed9c96f72
$ cd ../
```


* **Download meta-renesas**

```bash
$ git clone https://github.com/Avnet/meta-renesas.git -b dunfell_rzv2l_bsp_v300
```

* **Download meta-rzboard**

```bash
$ git clone https://github.com/Avnet/meta-rzboard.git -b rzboard_dunfell_5.10
```

Now,  the all Yocto related sources are already prepared.

```bash
$ ls ~/yocto_rzboard
meta-gplv2  meta-openembedded  meta-qt5  meta-renesas  meta-virtualization  poky
```



#### Build a image


*  **Create build configuration**

```bash
$ cd ~/yocto_rzboard
$ mkdir -p ~/yocto_rzboard/build/conf
$ cp meta-rzboard/conf/rzboard/* build/conf/
$ ls build/conf/
bblayers.conf  local.conf
```

*  **Build**
```bash
$ cd ~/yocto_rzboard/
$ source poky/oe-init-build-env build/
$ bitbake core-image
```

After the build is successfully completed, the output files will be located in build/tmp/deploy/images/rzboard/ directory.
