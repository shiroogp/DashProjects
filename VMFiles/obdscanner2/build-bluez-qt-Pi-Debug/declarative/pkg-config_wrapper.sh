#!/bin/sh
PKG_CONFIG_SYSROOT_DIR=/home/osboxes/raspi/sysroot
export PKG_CONFIG_SYSROOT_DIR
PKG_CONFIG_LIBDIR=/home/osboxes/raspi/sysroot/usr/lib/pkgconfig:/home/osboxes/raspi/sysroot/usr/share/pkgconfig:/home/osboxes/raspi/sysroot/usr/lib/arm-linux-gnueabihf/pkgconfig
export PKG_CONFIG_LIBDIR
exec pkg-config "$@"
