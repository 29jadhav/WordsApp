package com.vivek.wordsapp.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vivek.wordsapp.R
import com.vivek.wordsapp.databinding.ItemWordBinding
import com.vivek.wordsapp.model.Word


class WordAdapter : ListAdapter<Word, WordAdapter.WordViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WordViewHolder(
        ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: WordAdapter.WordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WordViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Word) = with(itemView) {
            binding.word = item

//            setOnClickListener {
//                // TODO: Handle on click
//            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem == newItem
    }
}