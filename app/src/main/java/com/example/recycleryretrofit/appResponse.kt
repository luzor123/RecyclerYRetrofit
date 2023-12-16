package com.example.recycleryretrofit

import com.google.gson.annotations.SerializedName

data class appResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("entries") val entries: List<Entry>
)

data class Entry(
    @SerializedName("API") val api: String,
    @SerializedName("Description") val description: String,
    @SerializedName("Auth") val auth: String,
    @SerializedName("HTTPS") val https: Boolean,
    @SerializedName("Cors") val cors: String,
    @SerializedName("Link") val link: String,
    @SerializedName("Category") val category: String
)