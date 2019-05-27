package com.example.trivia_db.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.trivia_db.Model.AllCount
import com.example.trivia_db.Model.Category
import com.example.trivia_db.Model.Question_Count
import com.example.trivia_db.R

class RecyclerViewAdapter(var countList:ArrayList<AllCount>, val context:Context,var categoryList:ArrayList<Category>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_questioncount, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvType_Count.text=countList[position].nameCategory
        holder.tvEasy_Count.text=countList[position].easy
        holder.tvMedium_Count.text=countList[position].medium
        holder.tvHard_Count.text=countList[position].hard
        holder.tvTotal_Count.text=countList[position].total

    }

    override fun getItemCount(): Int {
        return countList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Holds the TextView that will add each animal to
        val tvType_Count = itemView.findViewById<TextView>(R.id.count_type)
        val tvEasy_Count = itemView.findViewById<TextView>(R.id.count_easy)
        val tvMedium_Count = itemView.findViewById<TextView>(R.id.count_medium)
        val tvHard_Count = itemView.findViewById<TextView>(R.id.count_Hard)
        val tvTotal_Count = itemView.findViewById<TextView>(R.id.count_Total)

    }
}