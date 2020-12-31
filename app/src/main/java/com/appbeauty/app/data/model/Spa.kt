package com.appbeauty.app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Spa(
        val id : String = "",
        val name : String = "",
        val price : String = "",
        val image_link : String = "",
        val product_link : String = ""
) : Parcelable
