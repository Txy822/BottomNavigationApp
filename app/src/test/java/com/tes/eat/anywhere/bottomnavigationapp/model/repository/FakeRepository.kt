package com.tes.eat.anywhere.bottomnavigationapp.model.repository

import android.util.Log
import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Bible
import com.tes.eat.anywhere.bottomnavigationapp.model.data.news.News
import com.tes.eat.anywhere.bottomnavigationapp.other.Resource
import retrofit2.Response

class FakeRepository:Repository {

    private var shouldReturnNetworkError=false

    fun setshouldReturnNetworkError(value: Boolean){
        shouldReturnNetworkError=value
    }
    override suspend fun getNews(): Response<News> {
        TODO("Not yet implemented")
    }

    override suspend fun getBible(): Response<Bible> {
        val response=Bible("","","")
       shouldReturnNetworkError=true
        return if(shouldReturnNetworkError){
           Response.success(Bible())
        } else {
            Response.success(Bible("",""))
        }
    }
}