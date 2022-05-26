package com.example.harajtask

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PostItem(
    val body: String,
    val city: String,
    val commentCount: Int,
    val date: Int,
    val thumbURL: String,
    val title: String,
    val username: String
): Parcelable