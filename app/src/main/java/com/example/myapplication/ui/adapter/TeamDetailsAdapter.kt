package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.model.CustomTeams
import com.example.myapplication.databinding.TeamDetailsViewBinding

class TeamAdapter(
    private val teams: List<CustomTeams>
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamViewHolder {
        val binding = TeamDetailsViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    override fun getItemCount(): Int = teams.size

    class TeamViewHolder(
        private val binding: TeamDetailsViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(team: CustomTeams) {
            binding.team = team
            Glide.with(binding.root.context).load(team.strLogo).into(binding.teamBadgeImageView);
            binding.executePendingBindings()
        }
    }
}
