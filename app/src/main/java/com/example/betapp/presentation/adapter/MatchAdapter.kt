package com.example.betapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.betapp.R
import com.example.betapp.domain.model.Match

class MatchAdapter(private val matchList : List<Match>, private val activeButtonClick:(id:Int)-> Unit) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.match_item_layout,parent,false)
        return MatchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return matchList.size
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val item = matchList[position]

        holder.tvSportName.text = item.matchName
        holder.tvActiveStatus.text = item.activeStatus
        holder.tvTeamOne.text = item.teamFirst
        holder.tvTeamTwo.text = item.teamSecond
        holder.tvActiveBets.text = item.numberOfBetsAvailable.toString() + " Active Bets"
        holder.tvActiveBets.setOnClickListener { activeButtonClick(item.id) }
    }

    inner class MatchViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val teamOneImage: ImageView = view.findViewById<ImageView>(R.id.iv_team_one)
        val teamTwoImage: ImageView = view.findViewById<ImageView>(R.id.iv_team_two)
        val tvSportName: TextView = view.findViewById<TextView>(R.id.tv_sports_title)
        val tvActiveStatus: TextView = view.findViewById<TextView>(R.id.tv_active_status)
        val tvTeamOne : TextView = view.findViewById(R.id.tv_team_one)
        val tvTeamTwo : TextView = view.findViewById(R.id.tv_team_two)
        val tvActiveBets : TextView = view.findViewById(R.id.btn_active_bets)


    }
}