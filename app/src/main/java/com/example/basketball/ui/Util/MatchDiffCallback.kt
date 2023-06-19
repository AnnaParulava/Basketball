package com.example.basketball.ui.Util

import androidx.recyclerview.widget.DiffUtil
import com.example.basketball.pojo.Match

class MatchDiffCallback : DiffUtil.ItemCallback<Match>() {
    override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
        return oldItem.event_key == newItem.event_key
    }

    override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
        return oldItem == newItem
    }
}
