package com.tes.eat.anywhere.bottomnavigationapp.ui.bible

import com.tes.eat.anywhere.bottomnavigationapp.model.repository.FakeRepository
import org.junit.Assert.*
import org.junit.Before


import org.junit.Test

class BibleViewModelTest {


    private lateinit var viewModel:BibleViewModel



    @Before
    fun setUp(){
        viewModel= BibleViewModel(FakeRepository())
    }

    @Test
    fun getBible() {
        assertNotEquals(viewModel.bible, null)

    }

    @Test
    fun getCurrentData() {
        assertNotEquals(viewModel.currentData, null)

    }

    @Test
    fun setCurrentData() {
    }

    @Test
    fun testGetBible() {
        //assertNotEquals(viewModel.getBible()., null)
        }
    }
