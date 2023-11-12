SUMMARY = "Andrej Karpathy's llama2.c implementation"
DESCRIPTION = "Build Karpathy's llama2.c for a small footprint LLM capable of telling stories on the RZBoard"
HOMEPAGE = "https://github.com/karpathy/llama2.c"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=66c99a5ae1ef8ac9773ccd6eb051277c"

SRC_URI = "git://github.com/karpathy/llama2.c;branch=master \
           https://huggingface.co/karpathy/tinyllamas/resolve/main/stories15M.bin;name=stories15m \
           https://huggingface.co/karpathy/tinyllamas/resolve/main/stories42M.bin;name=stories42m \
"
SRC_URI[stories15m.sha256sum] = "cd590644d963867a2b6e5a1107f51fad663c41d79c149fbecbbb1f95fa81f49a"
SRC_URI[stories42m.sha256sum] = "9f65a1000e17d0bc167dd6332e0ce5119a0222a3d920cead5bce413bfab2ee7b"

SRCREV = "d9862069e7ef665fe6309e3c17398ded2f121bf5"

PV = "1.0.0+git${SRCPV}"

# do fetch puts git files in ${WORKDIR}/git
S = "${WORKDIR}/git"

# Ensure we use gnu hash format on the elf (part of yocto QA)
TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OEMAKE = "PREFIX=${prefix} CC='${CC}' CFLAGS='${TARGET_CFLAGS}' LDFLAGS='${TARGET_LDFLAGS}' DESTDIR='${B}'"
do_compile() {
    oe_runmake run
}

APP_INSTALL_DIRECTORY ?= "${ROOT_HOME}"

FILES_${PN} = " \
        ${APP_INSTALL_DIRECTORY}/cli_demos/llama/* \
"

do_install() {
        install -d ${D}${APP_INSTALL_DIRECTORY}/cli_demos/llama
        # only interested in the forward pass "run" exe
        install -m 755 ${B}/run ${D}${APP_INSTALL_DIRECTORY}/cli_demos/llama
        install ${WORKDIR}/stories15M.bin ${D}${APP_INSTALL_DIRECTORY}/cli_demos/llama
        install ${WORKDIR}/stories42M.bin ${D}${APP_INSTALL_DIRECTORY}/cli_demos/llama

        # used at runtime for inference
        install ${S}/tokenizer.bin ${D}${APP_INSTALL_DIRECTORY}/cli_demos/llama
}

COMPATIBLE_MACHINE="(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
