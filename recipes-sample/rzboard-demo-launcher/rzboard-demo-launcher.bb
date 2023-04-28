# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = ""
HOMEPAGE = "https://github.com/erstoddard/rzboard_demo_launcher#readme"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   node_modules/qs/LICENSE.md
#   node_modules/express-ws/LICENSE
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "MIT & Unknown & ISC"
LIC_FILES_CHKSUM = "file://node_modules/ms/license.md;md5=fd56fd5f1860961dfa92d313167c37a6 \
                    file://node_modules/path-to-regexp/LICENSE;md5=44088ba57cb871a58add36ce51b8de08 \
                    file://node_modules/accepts/LICENSE;md5=bf1f9ad1e2e1d507aef4883fff7103de \
                    file://node_modules/send/LICENSE;md5=5f1a8369a899b128aaa8a59d60d00b40 \
                    file://node_modules/send/node_modules/ms/license.md;md5=2b8bc52ae6b7ba58e1629deabd53986f \
                    file://node_modules/serve-static/LICENSE;md5=27b1707520b14d0bc890f4e75cd387b0 \
                    file://node_modules/methods/LICENSE;md5=c16a7dd9f946172f07086576d135d9d3 \
                    file://node_modules/object-inspect/LICENSE;md5=288162f1d1bfa064f127f2b42d2a656f \
                    file://node_modules/on-finished/LICENSE;md5=1b1f7f9cec194121fdf616b971df7a7b \
                    file://node_modules/statuses/LICENSE;md5=36e2bc837ce69a98cc33a9e140d457e5 \
                    file://node_modules/ipaddr.js/LICENSE;md5=88f60a4b6e44cb849b5d907a7664c0ef \
                    file://node_modules/encodeurl/LICENSE;md5=272621efa0ff4f18a73221e49ab60654 \
                    file://node_modules/mime-types/LICENSE;md5=bf1f9ad1e2e1d507aef4883fff7103de \
                    file://node_modules/has-symbols/LICENSE;md5=afee57a289508ed4df3456667778aaf6 \
                    file://node_modules/forwarded/LICENSE;md5=13babc4f212ce635d68da544339c962b \
                    file://node_modules/body-parser/LICENSE;md5=0afd201e48c7d095454eed4ac1184e40 \
                    file://node_modules/destroy/LICENSE;md5=d5eb22cf6cc99e645b98b28ee3503ddf \
                    file://node_modules/vary/LICENSE;md5=13babc4f212ce635d68da544339c962b \
                    file://node_modules/function-bind/LICENSE;md5=e7417c1a8ad83f88bcac21ad440d48b2 \
                    file://node_modules/utils-merge/LICENSE;md5=1cf0906082187f374cb9a63c54eb782c \
                    file://node_modules/has/LICENSE-MIT;md5=d000afc3c9ff3501a5610197db76a246 \
                    file://node_modules/content-disposition/LICENSE;md5=13babc4f212ce635d68da544339c962b \
                    file://node_modules/negotiator/LICENSE;md5=6417a862a5e35c17c904d9dda2cbd499 \
                    file://node_modules/safe-buffer/LICENSE;md5=badd5e91c737e7ffdf10b40c1f907761 \
                    file://node_modules/iconv-lite/LICENSE;md5=f942263d98f0d75e0e0101884e86261d \
                    file://node_modules/ws/LICENSE;md5=95833e8f03687308b0584a377b9e12b0 \
                    file://node_modules/side-channel/LICENSE;md5=375dc7ca936a14e9c29418d5263bd066 \
                    file://node_modules/unpipe/LICENSE;md5=934ab86a8ab081ea0326add08d550739 \
                    file://node_modules/xterm-addon-fit/LICENSE;md5=a3f4800475c9254c3fd6abcffbc62d61 \
                    file://node_modules/merge-descriptors/LICENSE;md5=aaf57ba8c5c9bf256fea7e943991a81a \
                    file://node_modules/xterm/LICENSE;md5=a6f7d231a2745fd8aaa465e2dd7c7c04 \
                    file://node_modules/node-pty/LICENSE;md5=c52651784ba3971ee506ab612dd90b72 \
                    file://node_modules/node-pty/deps/winpty/LICENSE;md5=f789abd9371883d4d06ae23a32aad961 \
                    file://node_modules/bootstrap/LICENSE;md5=e302e0588f2aafaf36d7f1b29bf558f8 \
                    file://node_modules/etag/LICENSE;md5=6e8686b7b13dd7ac8733645a81842c4a \
                    file://node_modules/bootstrap-icons/LICENSE.md;md5=e1cc2d7cfbe715e8f30ce4832fa40057 \
                    file://node_modules/call-bind/LICENSE;md5=0eb2c73daa0ecf037cbdf3d0bb0c98d5 \
                    file://node_modules/toidentifier/LICENSE;md5=1a261071a044d02eb6f2bb47f51a3502 \
                    file://node_modules/depd/LICENSE;md5=ebc30494fd072dc98368da73e1821715 \
                    file://node_modules/ee-first/LICENSE;md5=c8d3a30332ecb31cfaf4c0a06da18f5c \
                    file://node_modules/finalhandler/LICENSE;md5=462b10b32bb9175b97944aabef4aa171 \
                    file://node_modules/get-intrinsic/LICENSE;md5=0eb2c73daa0ecf037cbdf3d0bb0c98d5 \
                    file://node_modules/express/LICENSE;md5=5513c00a5c36cd361da863dd9aa8875d \
                    file://node_modules/setprototypeof/LICENSE;md5=4846f1626304c2c0f806a539bbc7d54a \
                    file://node_modules/safer-buffer/LICENSE;md5=3baebc2a17b8f5bff04882cd0dc0f76e \
                    file://node_modules/mime-db/LICENSE;md5=175b28b58359f8b4a969c9ab7c828445 \
                    file://node_modules/array-flatten/LICENSE;md5=44088ba57cb871a58add36ce51b8de08 \
                    file://node_modules/fresh/LICENSE;md5=373c2cf0978b37e434394a43b4cbbdb4 \
                    file://node_modules/range-parser/LICENSE;md5=d4246fb961a4f121eef5ffca47f0b010 \
                    file://node_modules/nan/LICENSE.md;md5=3952ff1c51e4ebe5b12c1bc501de4683 \
                    file://node_modules/proxy-addr/LICENSE;md5=6e8686b7b13dd7ac8733645a81842c4a \
                    file://node_modules/bytes/LICENSE;md5=013e95467eddb048f19a6f5b42820f86 \
                    file://node_modules/type-is/LICENSE;md5=0afd201e48c7d095454eed4ac1184e40 \
                    file://node_modules/media-typer/LICENSE;md5=c6e0ce1e688c5ff16db06b7259e9cd20 \
                    file://node_modules/cookie/LICENSE;md5=bc85b43b6f963e8ab3f88e63628448ca \
                    file://node_modules/parseurl/LICENSE;md5=e7842ed4f188e53e53c3e8d9c4807e89 \
                    file://node_modules/debug/LICENSE;md5=ddd815a475e7338b0be7a14d8ee35a99 \
                    file://node_modules/mime/LICENSE;md5=8e8ea2ad138ce468f8570a0edbadea65 \
                    file://node_modules/content-type/LICENSE;md5=f4b767f006864f81a4901347fe4efdab \
                    file://node_modules/escape-html/LICENSE;md5=f8746101546eeb9e4f6de64bb8bdf595 \
                    file://node_modules/qs/LICENSE.md;md5=b289135779dd930509ae81e6041690c0 \
                    file://node_modules/raw-body/LICENSE;md5=f22163d3bc6b4bc1bbbdf654fe30af5b \
                    file://node_modules/http-errors/LICENSE;md5=607209623abfcc77b9098f71a0ef52f9 \
                    file://node_modules/inherits/LICENSE;md5=5b2ef2247af6d355ae9d9f988092d470 \
                    file://node_modules/express-ws/LICENSE;md5=3a133f552782a1e694ed13c57356190d \
                    file://package.json;md5=6b44cfbb1dc85de71a782710a5dcabd3 \
                    file://node_modules/accepts/package.json;md5=32a15d6909fcae63e52d8664593d32d5 \
                    file://node_modules/array-flatten/package.json;md5=cb1aa7f817100a03395dd0163bf6ebe9 \
                    file://node_modules/body-parser/package.json;md5=fdd15e03ca10273d11b7d5cac72a3726 \
                    file://node_modules/bootstrap/package.json;md5=6a706139a10f0e63467b0e280783c5bb \
                    file://node_modules/bootstrap-icons/package.json;md5=92d8d336ec2c9067c28544ef2946284d \
                    file://node_modules/bytes/package.json;md5=5e3137feec27c5d88693e0cb2ff95d3c \
                    file://node_modules/call-bind/package.json;md5=9a9c527cb02ee791af16291838ddc217 \
                    file://node_modules/content-disposition/package.json;md5=5b285d4db057e7e72225e8e928d2ffa3 \
                    file://node_modules/content-type/package.json;md5=0de0482c40698c075e13e4d54ff34466 \
                    file://node_modules/cookie/package.json;md5=44d16bca62bc27cc2ba3030d62d42b49 \
                    file://node_modules/cookie-signature/package.json;md5=076c53814237236a9d1aa999f33ee501 \
                    file://node_modules/debug/package.json;md5=71a7656944ffe50cc27ebe02491ae49b \
                    file://node_modules/depd/package.json;md5=7f0a9d228c79f0ee4b89fc6117f1c687 \
                    file://node_modules/destroy/package.json;md5=6015f23c6e2fd79f4a6e29453ce4dc1d \
                    file://node_modules/ee-first/package.json;md5=3ed21090e07ef5dd57729a77c4291cb9 \
                    file://node_modules/encodeurl/package.json;md5=453a9bb10c91e0ec44f305b14e30ce82 \
                    file://node_modules/escape-html/package.json;md5=e9c758769fec9883d5ce3d30b8ee1047 \
                    file://node_modules/etag/package.json;md5=fec91cc11e50ee734c65c2d703db3884 \
                    file://node_modules/express/package.json;md5=6b157f15e22e6ad2de88252cb9750c15 \
                    file://node_modules/express-ws/package.json;md5=35054e70713100335fbf63dc17aefdc2 \
                    file://node_modules/finalhandler/package.json;md5=3d09ac571e0b6eaf8fdb9806118b6d30 \
                    file://node_modules/forwarded/package.json;md5=e7df15eb8d27abec5607f111411a9df1 \
                    file://node_modules/fresh/package.json;md5=193849cf18966de2814f4f6e85740069 \
                    file://node_modules/function-bind/package.json;md5=f453e26c8d3482b4c3736f53303b4ec5 \
                    file://node_modules/get-intrinsic/package.json;md5=ce6d7e4c40dacd2d1ff373362e39fd8e \
                    file://node_modules/has/package.json;md5=2fee243336ba5aeebed1e0145472cd49 \
                    file://node_modules/has-symbols/package.json;md5=854e83356c304640e79edea88870cb14 \
                    file://node_modules/http-errors/package.json;md5=f44e01d2e815367806c58207ac92a5fc \
                    file://node_modules/iconv-lite/package.json;md5=a8b97f25878ddc5419a9afe173037035 \
                    file://node_modules/inherits/package.json;md5=f73908dab55d4259f3ed052ce9fb2fbb \
                    file://node_modules/ipaddr.js/package.json;md5=17bc176c8d78f76c5e70cad7ba16a598 \
                    file://node_modules/media-typer/package.json;md5=127ce4abeb265c6eef7b45540241ca91 \
                    file://node_modules/merge-descriptors/package.json;md5=570e06d8ce0167e07a32ba70fdd56795 \
                    file://node_modules/methods/package.json;md5=8a9cbead0f83bf845207ad21534dfdfa \
                    file://node_modules/mime/package.json;md5=624ef11f91e60b224942ff81b13d10c6 \
                    file://node_modules/mime-db/package.json;md5=12c5cd5cfa1d4f45af207db1715d4b70 \
                    file://node_modules/mime-types/package.json;md5=7ad9a6119e3173ea667f1409fefba992 \
                    file://node_modules/ms/package.json;md5=cbd55880a650b56c3d5acddbbdbee9bc \
                    file://node_modules/nan/package.json;md5=90d5782584508bd7a12bf91656183010 \
                    file://node_modules/negotiator/package.json;md5=5d2bc8ae77831203c6d0ce3a17e599cf \
                    file://node_modules/node-pty/package.json;md5=cfc12c212a9b546262dca50760205d9e \
                    file://node_modules/object-inspect/package.json;md5=22d62d8feea651fab633c2aaef2ad7ad \
                    file://node_modules/on-finished/package.json;md5=436846dd0f4348ac2ee93c9c5eb291e4 \
                    file://node_modules/parseurl/package.json;md5=5b1493bd775444f0994d0b1063db1900 \
                    file://node_modules/path-to-regexp/package.json;md5=19e58964462995e183c1cd8147a9b8a1 \
                    file://node_modules/proxy-addr/package.json;md5=9b004d1140b24f5ae3f21fcdba8951fc \
                    file://node_modules/qs/package.json;md5=8293830097b45284f0fa44658785c307 \
                    file://node_modules/range-parser/package.json;md5=89b7cc42d2831a8061361ca29545f837 \
                    file://node_modules/raw-body/package.json;md5=8783ab409224eae8fc2de800e4383229 \
                    file://node_modules/safe-buffer/package.json;md5=b206856c7ef099626bf28cdc5498787a \
                    file://node_modules/safer-buffer/package.json;md5=274d956f400350c9f6cf96d22cdda227 \
                    file://node_modules/send/node_modules/ms/package.json;md5=a682078f64a677ddad1f50307a14b678 \
                    file://node_modules/send/package.json;md5=331e9be93662fd4127e84beed1b3c82c \
                    file://node_modules/serve-static/package.json;md5=c72c82df31ad86a65e2e48c33c03988b \
                    file://node_modules/setprototypeof/package.json;md5=3c0480d60c15fe4fe27ae36205d1f949 \
                    file://node_modules/side-channel/package.json;md5=ee22c26e53803fd87d3cbb2e2a46ebc7 \
                    file://node_modules/statuses/package.json;md5=210cda9d522bab0911dff42346dee4be \
                    file://node_modules/toidentifier/package.json;md5=fd6e2543a1b015cc443c7a2dcc4e3668 \
                    file://node_modules/type-is/package.json;md5=ffa244d8a6f745a081a0cdde026879c9 \
                    file://node_modules/unpipe/package.json;md5=f8318a554ed98c6a030942e9c14aaac8 \
                    file://node_modules/utils-merge/package.json;md5=0230ade39b9c19f5fcc29ed02dff4afe \
                    file://node_modules/vary/package.json;md5=3577fc17c1b964af7cfe2c17c73f84f3 \
                    file://node_modules/ws/package.json;md5=663069419de2af3783f805f4eec84d11 \
                    file://node_modules/xterm/package.json;md5=196526869ac98218f316825709c8f293 \
                    file://node_modules/xterm-addon-fit/package.json;md5=04ae8acf74c45138c8b8f5e48a0f8a27"

SRC_URI = " \
    git://github.com/avnet/rzboard_demo_launcher.git;branch=main \
    npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json \
    "

# Modify these as desired
PV = "1.0.0+git${SRCPV}"
SRCREV = "64281e9c66ca936cc9e1e83065515999c5033d60"

S = "${WORKDIR}/git"

inherit npm

LICENSE_${PN} = "Unknown"
LICENSE_${PN}-accepts = "MIT"
LICENSE_${PN}-array-flatten = "MIT"
LICENSE_${PN}-body-parser = "MIT"
LICENSE_${PN}-bootstrap = "MIT"
LICENSE_${PN}-bootstrap-icons = "MIT"
LICENSE_${PN}-bytes = "MIT"
LICENSE_${PN}-call-bind = "MIT"
LICENSE_${PN}-content-disposition = "MIT"
LICENSE_${PN}-content-type = "MIT"
LICENSE_${PN}-cookie = "MIT"
LICENSE_${PN}-cookie-signature = "Unknown"
LICENSE_${PN}-debug = "MIT"
LICENSE_${PN}-depd = "MIT"
LICENSE_${PN}-destroy = "MIT"
LICENSE_${PN}-ee-first = "MIT"
LICENSE_${PN}-encodeurl = "MIT"
LICENSE_${PN}-escape-html = "MIT"
LICENSE_${PN}-etag = "MIT"
LICENSE_${PN}-express = "MIT"
LICENSE_${PN}-express-ws = "Unknown"
LICENSE_${PN}-finalhandler = "MIT"
LICENSE_${PN}-forwarded = "MIT"
LICENSE_${PN}-fresh = "MIT"
LICENSE_${PN}-function-bind = "MIT"
LICENSE_${PN}-get-intrinsic = "MIT"
LICENSE_${PN}-has = "MIT"
LICENSE_${PN}-has-symbols = "MIT"
LICENSE_${PN}-http-errors = "MIT"
LICENSE_${PN}-iconv-lite = "MIT"
LICENSE_${PN}-inherits = "ISC"
LICENSE_${PN}-ipaddrjs = "MIT"
LICENSE_${PN}-media-typer = "MIT"
LICENSE_${PN}-merge-descriptors = "MIT"
LICENSE_${PN}-methods = "MIT"
LICENSE_${PN}-mime = "MIT"
LICENSE_${PN}-mime-db = "MIT"
LICENSE_${PN}-mime-types = "MIT"
LICENSE_${PN}-ms = "MIT"
LICENSE_${PN}-nan = "MIT"
LICENSE_${PN}-negotiator = "MIT"
LICENSE_${PN}-node-pty = "MIT Unknown"
LICENSE_${PN}-object-inspect = "MIT"
LICENSE_${PN}-on-finished = "MIT"
LICENSE_${PN}-parseurl = "MIT"
LICENSE_${PN}-path-to-regexp = "MIT"
LICENSE_${PN}-proxy-addr = "MIT"
LICENSE_${PN}-qs = "Unknown"
LICENSE_${PN}-range-parser = "MIT"
LICENSE_${PN}-raw-body = "MIT"
LICENSE_${PN}-safe-buffer = "MIT"
LICENSE_${PN}-safer-buffer = "MIT"
LICENSE_${PN}-send-ms = "MIT"
LICENSE_${PN}-send = "MIT"
LICENSE_${PN}-serve-static = "MIT"
LICENSE_${PN}-setprototypeof = "ISC"
LICENSE_${PN}-side-channel = "MIT"
LICENSE_${PN}-statuses = "MIT"
LICENSE_${PN}-toidentifier = "MIT"
LICENSE_${PN}-type-is = "MIT"
LICENSE_${PN}-unpipe = "MIT"
LICENSE_${PN}-utils-merge = "MIT"
LICENSE_${PN}-vary = "MIT"
LICENSE_${PN}-ws = "MIT"
LICENSE_${PN}-xterm = "MIT"
LICENSE_${PN}-xterm-addon-fit = "MIT"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "rzboard_demo_launcher.service"

APP_INSTALL_DIRECTORY ?= "${ROOT_HOME}"
SRC_URI_append = " file://rzboard_demo_launcher.service "

FILES_${PN} += " \
	${APP_INSTALL_DIRECTORY} \
	${APP_INSTALL_DIRECTORY}/demos/* \
    ${systemd_unitdir}/system/rzboard_demo_launcher.service \
"

do_install_append() {
	install -d ${D}${APP_INSTALL_DIRECTORY}/demos
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/rzboard_demo_launcher.service ${D}/${systemd_unitdir}/system
}

COMPATIBLE_MACHINE = "(rzboard)"
PACKAGE_ARCH = "${MACHINE_ARCH}"