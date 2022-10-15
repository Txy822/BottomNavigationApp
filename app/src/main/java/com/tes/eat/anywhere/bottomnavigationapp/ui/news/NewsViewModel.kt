package com.tes.eat.anywhere.bottomnavigationapp.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tes.eat.anywhere.bottomnavigationapp.model.data.news.News
import com.tes.eat.anywhere.bottomnavigationapp.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: Repository) : ViewModel() {

    private val _news = MutableLiveData<News>()
    val news: LiveData<News> = _news

    // API call to fetch the data
    fun getNews() {
        CoroutineScope(Dispatchers.Main).launch {
            val newsList = repository.getNews()

            // verify if the response was successful
            if (newsList.isSuccessful) {
                _news.postValue(newsList.body())
            } else {
                _news.postValue(News())
            }
        }
    }

}