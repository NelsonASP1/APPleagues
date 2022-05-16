package com.nelson.appleagues

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.nelson.appleagues.databinding.LayoutRvItemBinding

class MainAdapter() : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var teams = emptyList<Team>()

    fun setMovieList(teams: List<Team>) {
        this.teams = teams.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding: LayoutRvItemBinding = LayoutRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int){
        holder.bind(teams[position])

        holder.itemView.setOnClickListener { view ->
            val action = TeamFragmentDirections.actionTeamFragmentToDetailFragment(
                name = teams[position].team,
                imegenteam = teams[position].logo,
                imegeteamJersey = teams[position].logoTeamJersey,
                imegenstadium = teams[position].logoStadiumThumb,
                namestadium = teams[position].stadium,
                description = teams[position].description)
            view.findNavController().navigate(action)
        }
    }

    class MainViewHolder(private val itemBinding: LayoutRvItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
    var name_character = itemBinding.title

    fun bind(item: Team) {
        name_character.text = item.team
        Glide.with(itemBinding.root)
            .load(item.logo)
            .into(itemBinding.moviePoster)
        }
    }
}

