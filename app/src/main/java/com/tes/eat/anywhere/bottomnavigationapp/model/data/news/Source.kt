package com.tes.eat.anywhere.bottomnavigationapp.model.data.news


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("Id")
    val idModel: String? = "",
    @SerializedName("Name")
    val nameModel: String = ""
)