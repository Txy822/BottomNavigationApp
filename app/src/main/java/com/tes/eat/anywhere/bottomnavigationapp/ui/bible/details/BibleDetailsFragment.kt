package com.tes.eat.anywhere.bottomnavigationapp.ui.bible.details

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.tes.eat.anywhere.bottomnavigationapp.R
import com.tes.eat.anywhere.bottomnavigationapp.databinding.FragmentBibleDetailsBinding
import com.tes.eat.anywhere.bottomnavigationapp.ui.bible.BibleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BibleDetailsFragment : Fragment(R.layout.fragment_bible_details) {

    lateinit var binding: FragmentBibleDetailsBinding
    val viewModel by activityViewModels<BibleViewModel>()
//    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBibleDetailsBinding.inflate(inflater)
        // Inflate the layout for this fragment

        viewModel.currentData.let {
            binding.title.text = "Verse: ${it.verseModel}"
            binding.detail.text = "${it.textModel}"
        }
        return binding.root
    }


}