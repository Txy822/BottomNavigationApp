package com.tes.eat.anywhere.bottomnavigationapp.model.remote.bible

import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Bible
import retrofit2.Response
import retrofit2.http.GET

interface BibleApi {

    @GET(BibleApiDetails.EndPoint)
    suspend fun getBible(): Response<Bible>
}