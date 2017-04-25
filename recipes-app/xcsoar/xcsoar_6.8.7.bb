#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "XCSoar Application"
SECTION = "applications"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRCREV = "ad8f5442071b42d48c323fbc965fad2e20be4049"

TARGET_CFLAGS += "-Wno-error=unused-result -fno-strict-overflow -Wno-error=maybe-uninitialized"
TARGET_LDFLAGS += "-L${STAGING_LIBDIR}"

SRC_URI = "git://git@github.com/XCSoar/XCSoar.git;protocol=ssh;branch=master"

S = "${WORKDIR}/git"

do_configure_prepend() {
	git submodule init
	git submodule update
}

#do_compile() {
#	     ${CC} helloworld.c -o helloworld
#}

#do_install() {
#	     install -d ${D}${bindir}
#	     install -m 0755 helloworld ${D}${bindir}
#}

DEPENDS_${PN} = "libpng"
RDEPENDS_${PN} = "libpng"
