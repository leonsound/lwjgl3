/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package openvr.templates

import org.lwjgl.generator.*
import openvr.*

val VRDriverManager = "VRDriverManager".nativeClass(
    Module.OPENVR,
    prefixMethod = "VRDriverManager_",
    library = OPENVR_LIBRARY,
    binding = OPENVR_FNTABLE_BINDING
) {
    documentation =
        """
        """

    uint32_t("GetDriverCount", "", void())

    uint32_t(
        "GetDriverName",
        "",

        DriverId_t("nDriver", ""),
        Return(RESULT, includesNT = true)..nullable..charASCII.p.OUT("pchValue", ""),
        AutoSize("pchValue")..uint32_t("unBufferSize", ""),

        returnDoc = "the length of the number of bytes necessary to hold this string including the trailing null"
    )

    DriverHandle_t(
        "GetDriverHandle",
        "Returns the property container handle for the specified driver.",

        charASCII.p("pchDriverName", "the driver name")
    )
}