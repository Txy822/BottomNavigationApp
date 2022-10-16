package com.tes.eat.anywhere.bottomnavigationapp.ui.bible

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tes.eat.anywhere.bottomnavigationapp.R
import com.tes.eat.anywhere.bottomnavigationapp.databinding.FragmentBibleBinding
import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Bible
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BibleFragment : Fragment() {

    lateinit var binding: FragmentBibleBinding

    private val viewModel by activityViewModels<BibleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBibleBinding.inflate(inflater)
        val swipeRefreshLayout = binding.swipeContainer
        // observe the changes in viewmodel liveData
        viewModel.bible.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getBible()
        swipeRefreshLayout.setOnRefreshListener{
            // observe the changes in viewmodel liveData
            viewModel.bible.observe(viewLifecycleOwner) {
                setupUI(it)
            }
            viewModel.getBible()
            // This line is important as it explicitly refreshes only once
            // If "true" it implicitly refreshes forever
            swipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }

    private fun setupUI(bibleList: Bible) {
        binding.rvBible.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BibleAdapter(
                bibleList
            ){item->


                viewModel.currentData=item
                findNavController().navigate(R.id.action_navigation_bible_to_navigation_bibleDetails)
            }
        }
    }
}
