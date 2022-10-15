package com.tes.eat.anywhere.bottomnavigationapp.model.data.news


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author")
    val authorModel: String? = "",
    @SerializedName("publishedAt")
    val publishedAtModel: String = "",
    @SerializedName("source")
    val sourceModel: Source = Source(),
    @SerializedName("title")
    val titleModel: String = "",
    @SerializedName("url")
    val urlModel: String = ""
)