package com.ynov.kotlin.rickmorty.presentation.list.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.model.RMCharacter
import com.ynov.kotlin.rickmorty.presentation.list.activity.CharacterDetailActivity
import com.ynov.kotlin.rickmorty.presentation.list.activity.MainActivity
import kotlinx.android.synthetic.main.character_layout.view.*

class CharacterListAdapter: RecyclerView.Adapter<CharacterListAdapter.ViewHolder>(){

    private var characterList: MutableList<RMCharacter> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.character_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun updateList(characterList: List<RMCharacter>){
        this.characterList.clear()
        this.characterList.addAll(characterList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList.get(position))
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        var image : ImageView = itemView.findViewById(R.id.Avatar)
        var name : TextView = itemView.findViewById(R.id.Name)
        var type : TextView = itemView.findViewById(R.id.Type)
        var id : String? =""

        fun bind(rmChacter: RMCharacter){
            Picasso.get().load(rmChacter.image).into(image)
            itemView.Name.text = rmChacter.name
            itemView.Type.text = rmChacter.type
            id = rmChacter.id
        }
        init {
            itemView.setOnClickListener {
                var intent=Intent(itemView.context, CharacterDetailActivity::class.java)
                intent.putExtra("id",id)
                itemView.context.startActivity(intent)
            }
        }
    }
}