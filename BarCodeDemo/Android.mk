LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_STATIC_JAVA_LIBRARIES := QRcore

LOCAL_SRC_FILES := $(call all-java-files-under, src)

LOCAL_PACKAGE_NAME := SkyQRCode
LOCAL_CERTIFICATE := platform

include $(BUILD_PACKAGE)

# Use the following include to make our test apk.
include $(call all-makefiles-under,$(LOCAL_PATH))

##################################################
include $(CLEAR_VARS)


LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := QRcore:libs/QRcore.jar


include $(BUILD_MULTI_PREBUILT)


# Use the folloing include to make our test apk.
include $(call all-makefiles-under,$(LOCAL_PATH))