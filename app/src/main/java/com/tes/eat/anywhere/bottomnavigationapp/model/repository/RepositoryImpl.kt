package com.tes.eat.anywhere.bottomnavigationapp.model.repository

import com.tes.eat.anywhere.bottomnavigationapp.model.data.news.News
import com.tes.eat.anywhere.bottomnavigationapp.model.remote.news.NewsApi
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl  @Inject constructor (private val news: NewsApi
) : Repository  {

    override suspend fun getNews() = news.getNews()
//    override suspend fun getNewsTile(): Response<List<News>> {
//        return  listOf<News>()
//    }

}