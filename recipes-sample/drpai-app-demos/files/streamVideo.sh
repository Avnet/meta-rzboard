#!/bin/sh

REMOTE_HOST_IP_ADDR=192.168.1.88
REMOTE_HOST_PORT=51372

# Gstreamer H.264 camera video streaming
gst-launch-1.0 --gst-debug=3 v4l2src device=/dev/video0 \
! video/x-raw, width=1280, height=720 ! videoconvert \
! video/x-raw, format=NV12 ! omxh264enc control-rate=2 \
target-bitrate=10485760 interval_intraframes=14 periodicty-idr=2 use-dmabuf=false \
! video/x-h264, profile=\(string\)high,level=\(string\)4.2 \
! h264parse ! rtph264pay ! queue ! udpsink host=${REMOTE_HOST_IP_ADDR} port=${REMOTE_HOST_PORT}

