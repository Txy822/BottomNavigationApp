package com.tes.eat.anywhere.bottomnavigationapp.model.data.bible


import com.google.gson.annotations.SerializedName

data class Verse(
    @SerializedName("book_id")
    val bookIdModel: String = "",
    @SerializedName("book_name")
    val bookNameModel: String = "",
    @SerializedName("chapter")
    val chapterModel: Int = 0,
    @SerializedName("text")
    val textModel: String = "",
    @SerializedName("verse")
    val verseModel: Int = 0
)