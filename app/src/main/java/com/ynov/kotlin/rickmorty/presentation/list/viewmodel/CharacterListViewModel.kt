package com.ynov.kotlin.rickmorty.presentation.list.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ynov.kotlin.rickmorty.model.RMCharacter
import com.ynov.kotlin.rickmorty.presentation.RMApplication
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CharacterListViewModel: ViewModel() {

    var characterListLiveData = MutableLiveData<List<RMCharacter>>()

    init {
        RMApplication.app.dataRepository.retrieveCharacterList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    characterListLiveData.postValue(it)
                },
                onError = {
                    // TODO ça ne sert à rien de throw une erreur, le but de Rx c'est justement de gérer les erreurs,
                    //  pas de faire crash l'appli à la fin du flux
                    throw error(it)
                }
            )
    }
}