package com.tes.eat.anywhere.bottomnavigationapp.ui.bible.details

import android.provider.Contacts
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Bible
import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Verse
import com.tes.eat.anywhere.bottomnavigationapp.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BibleDetailsViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    var currentData= Verse()
    private val _verse = MutableLiveData<Bible>()
    val verse: LiveData<Bible> = _verse

    // API call to fetch the data
    fun getVerse() {
        CoroutineScope(Dispatchers.Main).launch {
            val verseList = repository.getBible()
            // verify if the response was successful
            if (verseList.isSuccessful) {
                _verse.postValue(verseList.body())
            } else {
                _verse.postValue(Bible())
            }
        }
    }
}