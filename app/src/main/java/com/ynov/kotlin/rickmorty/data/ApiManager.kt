package com.ynov.kotlin.rickmorty.data

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val API_BASE_URL = "https://rickandmortyapi.com/"

class ApiManager {

    private val service: ApiService

    interface ApiService {
        @GET("api/character")
        fun retrieveCharacterList(): Single<CharacterListResultRemoteEntity>
        @GET("api/character/{id}")
        fun retrieveCharacterDetailsById(@Path("id") id: String): Single<CharacterRemoteEntity>
    }

    fun retrieveCharacterList(): Single<List<CharacterRemoteEntity>> =
        service.retrieveCharacterList().map{
            it.results
        }
    fun retrieveCharacterDetailsById(id: String): Single<CharacterRemoteEntity> =
        service.retrieveCharacterDetailsById(id)

    init {
        service = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}