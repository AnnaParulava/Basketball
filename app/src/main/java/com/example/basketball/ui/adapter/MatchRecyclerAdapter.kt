package com.example.basketball.ui.adapter

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basketball.databinding.MatchItemBinding
import com.example.basketball.pojo.Match

class MatchRecyclerAdapter : ListAdapter<Match, MatchRecyclerAdapter.MatchViewHolder>(
    MatchDiffCallback()
) {

    var matchList: List<Match> = listOf()

    inner class MatchViewHolder(binding: MatchItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val dateTextView: TextView = binding.dateTextView
        val statusTextView: TextView = binding.statusTextView
        val homeTeamLogoImageView: ImageView = binding.homeTeamLogoImageView
        val awayTeamLogoImageView: ImageView = binding.homeTeamLogoImageView
        val homeTeamNameTextView: TextView = binding.homeTeamNameTextView
        val awayTeamNameTextView: TextView = binding.awayTeamNameTextView
        val finalResultTextView: TextView = binding.awayTeamNameTextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MatchItemBinding.inflate(inflater, parent, false)
        return MatchViewHolder(binding)
    }

    override fun getItemCount(): Int = matchList.size


    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val matchItem = matchList[position]

        with(holder) {
            dateTextView.text = matchItem.event_date
            statusTextView.text = matchItem.event_status
            homeTeamNameTextView.text = matchItem.event_home_team
            awayTeamNameTextView.text = matchItem.event_away_team
            finalResultTextView.text = matchItem.event_final_result
        }
    }

    class MatchDiffCallback : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem.event_key == newItem.event_key
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem == newItem
        }
    }

}





