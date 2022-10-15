package com.tes.eat.anywhere.bottomnavigationapp.model.remote.news

import com.tes.eat.anywhere.bottomnavigationapp.model.data.news.News
import com.tes.eat.anywhere.bottomnavigationapp.model.remote.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET(NewsApiDetails.EndPoint) //to define type of request GET, POST, PUT
    suspend fun getNews(
        @Query("country") country: String = "GB",
        @Query("apiKey") apiKey: String = NewsApiDetails.API_KEY
    ): Response<News>
}
//ApiResponse<News>