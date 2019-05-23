package com.ynov.kotlin.rickmorty.presentation.list.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.presentation.list.viewmodel.CharacterViewModel


class CharacterDetailActivity : AppCompatActivity(){
     lateinit var viewModel : CharacterViewModel
    lateinit var image : ImageView
    lateinit var name : TextView
    lateinit var status : TextView
    lateinit var specise : TextView
    lateinit var type : TextView
    lateinit var genre : TextView
    lateinit var origine : TextView
    lateinit var location : TextView
    lateinit var epCount : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_detail_activity)
        val id = intent.getStringExtra("id")
        viewModel = CharacterViewModel(id)
        image =  findViewById(R.id.character_delail_activity_avatar)
        name = findViewById(R.id.character_delail_activity_name)
        status = findViewById(R.id.character_delail_activity_status)
        specise = findViewById(R.id.character_delail_activity_species)
        genre = findViewById(R.id.character_delail_activity_gender)
        type =  findViewById(R.id.character_delail_activity_type)
        origine = findViewById(R.id.character_delail_activity_origin)
        location = findViewById(R.id.character_delail_activity_location)
        epCount = findViewById(R.id.character_delail_activity_ep_count)
        viewModel.characterData.observe(this, Observer {
           Picasso.get().load(it.image).into(image)
            name.text = replaceIfEmpty(it.name)
            supportActionBar?.title = "Informations sur " + name.text
            status.text = replaceIfEmpty(it.status)
            specise.text = replaceIfEmpty(it.species)
            genre.text = replaceIfEmpty(it.gender)
            type.text = replaceIfEmpty(it.type)
            origine.text = replaceIfEmpty(it.origin?.name)
            location.text = replaceIfEmpty(it.location?.name)
            epCount.text = replaceIfEmpty(it.episode?.count().toString())


        })
    }
    private fun replaceIfEmpty(string : String?) : String?{
        if(string.isNullOrBlank() || string == "unknown"){
            return "N/A"
        }
        return string
    }

}