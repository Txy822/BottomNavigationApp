package com.tes.eat.anywhere.bottomnavigationapp.model.remote.news

import com.tes.eat.anywhere.bottomnavigationapp.BuildConfig
import com.tes.eat.anywhere.bottomnavigationapp.model.remote.news.NewsApiDetails.API_KEY

object NewsApiDetails {
    const val BASE_URL="https://newsapi.org/"
    const val EndPoint="v2/top-headlines"
    const val API_KEY=BuildConfig.API_KEY
}