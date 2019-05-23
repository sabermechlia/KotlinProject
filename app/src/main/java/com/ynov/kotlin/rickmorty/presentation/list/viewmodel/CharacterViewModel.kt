package com.ynov.kotlin.rickmorty.presentation.list.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ynov.kotlin.rickmorty.model.RMCharacter
import com.ynov.kotlin.rickmorty.presentation.RMApplication
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CharacterViewModel(id: String): ViewModel() {

    var characterData = MutableLiveData<RMCharacter>()

    init {
        RMApplication.app.dataRepository.retrieveCharacterDetailsById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    characterData.postValue(it)
                },
                onError = {
                    throw error(it)
                }
            )
    }
}