package com.tes.eat.anywhere.bottomnavigationapp.ui.bible

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tes.eat.anywhere.bottomnavigationapp.R
import com.tes.eat.anywhere.bottomnavigationapp.databinding.ItemBibleBinding
import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Bible
import com.tes.eat.anywhere.bottomnavigationapp.model.data.bible.Verse

class BibleAdapter(
    private val bible: Bible,
    val clickListner: (Verse) -> Unit
): RecyclerView.Adapter<BibleAdapter.BibleViewHolder>() {


    class BibleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemBibleBinding.bind(itemView)
        val rootItem=binding.bibleItem

        fun setupUI(verse: Verse) {
            binding.bibleItem.text = "Chapter : ${verse.chapterModel} -> verse: ${verse.verseModel} \n" +

                    "Book Name:${verse.bookNameModel}"

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BibleAdapter.BibleViewHolder {
        return BibleAdapter.BibleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bible, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BibleAdapter.BibleViewHolder, position: Int) {
        holder.setupUI(bible.versesModel[position])
        holder.rootItem.setOnClickListener {
            clickListner.invoke(bible.versesModel[position])
        }

    }

    override fun getItemCount()=bible.versesModel.size

}