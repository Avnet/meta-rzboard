require recipes-core/images/core-image.inc
require recipes-core/images/core-image-qt5.inc

# Edge Impulse CLI requires to have nodejs and npm packages
IMAGE_INSTALL_append = " \
    nodejs \
    nodejs-npm \
    "

# Wildcard to preferred version of nodejs to 14.x, as this version is
# provided in meta-oe. 
# Prefer higher versions compatible with Edge Impulse (we will want to bump this with future yocto updates)
PREFERRED_VERSION_nodejs = "14.%"
PREFERRED_VERSION_nodejs-npm = "14.%"

# Package up images to release
# Call with bitbake avnet-core-image -c release
do_release() {
    # Variables
    RZ_IMAGES_DIR=${DEPLOY_DIR}/images/rzboard
    RELEASE_DIR=${DEPLOY_DIR}/images/rzboard/release

    # Clear existing distribution package
    if [ -d ${RELEASE_DIR} ]; then
        rm -rf ${RELEASE_DIR}
    fi;

    # Create release directory
    mkdir ${RELEASE_DIR}
    mkdir ${RELEASE_DIR}/adb

    # Copy images
    cp ${RZ_IMAGES_DIR}/fip-rzboard.srec ${RELEASE_DIR}
    cp ${RZ_IMAGES_DIR}/bl2_bp-rzboard.srec ${RELEASE_DIR}
    cp ${RZ_IMAGES_DIR}/Flash_Writer_SCIF_rzboard.mot ${RELEASE_DIR}
    cp ${RZ_IMAGES_DIR}/avnet-core-image-rzboard.wic ${RELEASE_DIR}

    # Flash util essentials
    cp ${RZ_IMAGES_DIR}/requirements.txt ${RELEASE_DIR}
    cp -r ${RZ_IMAGES_DIR}/flash_utils ${RELEASE_DIR}
    cp ${RZ_IMAGES_DIR}/flash_rzboard.py ${RELEASE_DIR}
    cp ${RZ_IMAGES_DIR}/adb/*.zip ${RELEASE_DIR}/adb

    cp ${RZ_IMAGES_DIR}/avnet-core-image-rzboard.manifest ${RELEASE_DIR}/

    tar -zcf ${RZ_IMAGES_DIR}/release.tar.gz -C ${RZ_IMAGES_DIR} release

    bbnote "Release package created at ${RZ_IMAGES_DIR}/release.tar.gz"
}

addtask release
do_release[depends] = "avnet-core-image:do_image"
