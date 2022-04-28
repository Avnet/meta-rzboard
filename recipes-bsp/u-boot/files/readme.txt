# How to configure the environment variables in uEnv.txt

It is possible to set an environment variable in uEnv.txt. To load the devicetree overlay file from
"overlay/" folder, you should set "enable_overlay_" or "fdt_extra_overlays". Also you can set some 
environment variables from uboot to overwrite the old settings.

Refer to the following description for different boards.


## For Rzboard U-Boot Env
/-----------------------|--------------|------------------------------
|       Config          | Value if set |     To be loading
|-----------------------|--------------|------------------------------
| enable_overlay_disp   |  'hdmi'      |  rzboard-hdmi.dtbo
|                       |  'mipi'      |  rzboard-mipi.dtbo
|-----------------------|--------------|------------------------------
| enable_overlay_gpio   | '1' or 'yes' |  rzboard-ext-gpio.dtbo
|-----------------------|--------------|------------------------------
| enable_overlay_i2c    | '1' or 'yes' |  rzboard-ext-i2c.dtbo
|---------------------------------------------------------------------
| fdtfile              : is a base dtb file, should be set rzboard.dtb
|---------------------------------------------------------------------
| fdt_extra_overlays   : other dtbo files to be loading, such as rzboard-f1.dtbo rzboard-f2.dtbo
|---------------------------------------------------------------------
|---------------------------------------------------------------------
|  uboot env   : you could set some environment variables of u-boot here, such as 'console=' 'bootargs=' 
\---------------------------------------------------------------------
default setting:
    fdtfile=rzboard.dtb
    enable_overlay_disp=hdmi
    enable_overlay_gpio=1
    #fdt_extra_overlays=1.dtbo 2.dtbo 3.dtbo
    #ethaddr=aa:bb:cc:aa:bb:cc
