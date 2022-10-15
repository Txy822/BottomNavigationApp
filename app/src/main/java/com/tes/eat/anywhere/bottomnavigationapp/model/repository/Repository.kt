package com.tes.eat.anywhere.bottomnavigationapp.model.repository

import com.tes.eat.anywhere.bottomnavigationapp.model.data.news.News
import com.tes.eat.anywhere.bottomnavigationapp.model.remote.ApiResponse
import retrofit2.Response

interface Repository {

    suspend fun  getNews(): Response<News>

    //suspend fun  getNewsTile(): Response<List<News>>
}