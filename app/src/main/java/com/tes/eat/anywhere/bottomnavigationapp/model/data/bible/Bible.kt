package com.tes.eat.anywhere.bottomnavigationapp.model.data.bible


import com.google.gson.annotations.SerializedName

data class Bible(
    @SerializedName("reference")
    val referenceModel: String = "",
    @SerializedName("text")
    val textModel: String = "",
    @SerializedName("translation_id")
    val translationIdModel: String = "",
    @SerializedName("translation_name")
    val translationNameModel: String = "",
    @SerializedName("translation_note")
    val translationNoteModel: String = "",
    @SerializedName("verses")
    val versesModel: List<Verse> = listOf()
)