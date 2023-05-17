require recipes-core/images/core-image.inc
require recipes-core/images/core-image-qt5.inc

# Edge Impulse CLI requires to have nodejs and npm packages
IMAGE_INSTALL_append = " \
    nodejs \
    nodejs-npm \
    "
