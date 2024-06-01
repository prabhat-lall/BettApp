package com.example.betapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.betapp.R
import com.example.betapp.data.model.SportDTO
import com.example.betapp.domain.model.Sport

class SportTypeAdapter(private val sportsList : List<Sport>) : RecyclerView.Adapter<SportTypeAdapter.GameTypeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameTypeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sports_item_layout,parent,false)
        return GameTypeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sportsList.size
    }

    override fun onBindViewHolder(holder: GameTypeViewHolder, position: Int) {
        val item = sportsList[position]

        holder.sportsName.text = item.sportsName
    }

    inner class GameTypeViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById<ImageView>(R.id.iv_sport_icon)
        val sportsName: TextView = view.findViewById<TextView>(R.id.tv_sports_name)
    }
}