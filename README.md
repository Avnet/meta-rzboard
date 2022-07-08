# meta-rzboard

This is a meta-layer for Avnet RzBoard.

- Yocto dunfell 3.1.5 support:  Avnet RzBoard



## How to Build


#### Build environment

It is recommended to setup the development environment on a *<font color=red>64-bit Ubuntu 20.04 LTS</font>* machine.
The following packages are required:

```bash
$ sudo apt update
$ sudo apt install -y wget git-core diffstat unzip texinfo gcc-multilib \
build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa \
libsdl1.2-dev pylint3 xterm rsync curl locales bash-completion
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

Now,  the all Yocto related sources are already prepared.

```bash
$ ls ~/yocto_rzboard
meta-gplv2  meta-openembedded  meta-renesas  meta-rzboard  poky
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
