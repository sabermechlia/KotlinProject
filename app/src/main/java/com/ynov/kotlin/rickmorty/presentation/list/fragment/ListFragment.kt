package com.ynov.kotlin.rickmorty.presentation.list.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ynov.kotlin.rickmorty.R
import com.ynov.kotlin.rickmorty.presentation.list.adapter.CharacterListAdapter
import com.ynov.kotlin.rickmorty.presentation.list.viewmodel.CharacterListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment(){

    private var viewModel :CharacterListViewModel = CharacterListViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var characterListAdapter = CharacterListAdapter()
        fragment_list_recyclerview.layoutManager = LinearLayoutManager(requireContext())
        fragment_list_recyclerview.adapter = characterListAdapter
        viewModel.characterListLiveData.observe(this, Observer {
            characterListAdapter.updateList(it)
        })

    }
}