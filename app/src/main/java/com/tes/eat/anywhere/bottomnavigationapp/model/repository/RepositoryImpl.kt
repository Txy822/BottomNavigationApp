package com.tes.eat.anywhere.bottomnavigationapp.model.repository

import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Bible
import com.tes.eat.anywhere.bottomnavigationapp.model.data.news.News
import com.tes.eat.anywhere.bottomnavigationapp.model.remote.bible.BibleApi
import com.tes.eat.anywhere.bottomnavigationapp.model.remote.news.NewsApi
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl  @Inject constructor (
    private val news: NewsApi,
    private val bible: BibleApi
) : Repository  {

    override suspend fun getNews() = news.getNews()
    override suspend fun getBible() =bible.getBible()

}