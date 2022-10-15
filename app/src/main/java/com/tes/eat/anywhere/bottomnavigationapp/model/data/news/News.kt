package com.tes.eat.anywhere.bottomnavigationapp.model.data.news


import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("articles")
    val articlesModel: List<Article> = listOf(),
    @SerializedName("status")
    val statusModel: String = "",
    @SerializedName("totalResults")
    val totalResultsModel: Int = 0
)