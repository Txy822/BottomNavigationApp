package com.tes.eat.anywhere.bottomnavigationapp.model.repository

import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Bible
import com.tes.eat.anywhere.bottomnavigationapp.model.data.news.News
import com.tes.eat.anywhere.bottomnavigationapp.model.remote.ApiResponse
import com.tes.eat.anywhere.bottomnavigationapp.other.Resource
import retrofit2.Response

interface Repository {

    suspend fun  getNews(): Response<News>

    suspend fun  getBible(): Response<Bible>
}