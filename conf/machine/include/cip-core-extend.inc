GCCVERSION_debian = "${@'9.5.0' if 'Bullseye' in '${CIP_MODE}' else '9.3.0'}"
BINUVERSION_debian = "${@'2.34%' if 'Bullseye' in '${CIP_MODE}' else '2.31.%'}"
PREFERRED_VERSION_gdb_debian = "${@'9.1' if 'Bullseye' in '${CIP_MODE}' else '8.1'}"

PREFERRED_PROVIDER_virtual/crypt ?= "glibc"
PREFERRED_PROVIDER_virtual/nativesdk-crypt ?= "nativesdk-glibc"
PREFERRED_PROVIDER_virtual/lib32-crypt ?= "lib32-glibc"
