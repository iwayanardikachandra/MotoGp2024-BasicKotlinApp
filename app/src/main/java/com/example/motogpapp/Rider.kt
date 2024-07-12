package com.example.motogpapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rider(
    val name: String,
    val description: String,
    val photoUrl: String
) : Parcelable
