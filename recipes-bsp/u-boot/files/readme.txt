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
| enable_overlay_camera |  'ov5640'    |  rzboard-ov5640.dtbo
|-----------------------|--------------|------------------------------
| enable_overlay_adc    | '1' or 'yes' |  rzboard-adc.dtbo
|-----------------------|--------------|------------------------------
| enable_overlay_can    | '1' or 'yes' |  rzboard-can.dtbo
|-----------------------|--------------|------------------------------
| enable_overlay_cm33   | '1' or 'yes' |  rzboard-cm33.dtbo
|-----------------------|--------------|------------------------------
| enable_overlay_audio  | '1' or 'yes' |  rzboard-lite-audio.dtbo
|-----------------------|--------------|------------------------------
| enable_overlay_i2c    | '1' or 'yes' |  rzboard-ext-i2c.dtbo
|-----------------------|--------------|------------------------------
| enable_overlay_spi    | '1' or 'yes' |  rzboard-ext-spi.dtbo
|-----------------------|--------------|------------------------------
| enable_overlay_uart2  | '1' or 'yes' |  rzboard-ext-uart2.dtbo
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
    #fdt_extra_overlays=rzboard-mipi-ph720128t003.dtbo
    #fdt_extra_overlays=1.dtbo 2.dtbo 3.dtbo
    #ethaddr=aa:bb:cc:aa:bb:cc
