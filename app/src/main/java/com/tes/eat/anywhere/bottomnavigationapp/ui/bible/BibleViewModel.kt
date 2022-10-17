package com.tes.eat.anywhere.bottomnavigationapp.ui.bible

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Bible
import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Verse
import com.tes.eat.anywhere.bottomnavigationapp.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BibleViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _bible = MutableLiveData<Bible>()
    val bible: LiveData<Bible> = _bible
    var currentData= Verse()

    // API call to fetch the data
    fun getBible() {
        CoroutineScope(Dispatchers.Main).launch {
            val bibleSectionList = repository.getBible()

            // verify if the response was successful
            if (bibleSectionList.isSuccessful) {
                _bible.postValue(bibleSectionList.body())
            } else {
                _bible.postValue(Bible())
            }
        }
    }

}