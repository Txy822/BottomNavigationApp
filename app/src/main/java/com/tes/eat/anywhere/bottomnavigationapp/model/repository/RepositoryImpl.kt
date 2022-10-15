package com.tes.eat.anywhere.bottomnavigationapp.model.repository

import com.tes.eat.anywhere.bottomnavigationapp.model.remote.news.NewsApi
import javax.inject.Inject

class RepositoryImpl  @Inject constructor (private val news: NewsApi
) : Repository  {

    override suspend fun getNews() = news.getNews()

}