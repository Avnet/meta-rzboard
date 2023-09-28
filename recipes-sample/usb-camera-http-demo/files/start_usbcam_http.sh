#!/bin/bash
# BASE_PKG=rzv2l_drpai-sample-application_ver7.xx

ifconfig | grep eth0 -A 1
cd /home/root/app_demos/app_usbcam_http/exe
./sample_app_usbcam_http
