package com.ynov.kotlin.rickmorty.data

import io.reactivex.Single

import com.ynov.kotlin.rickmorty.model.RMCharacter

class DataRepository(private val apiManager: ApiManager) {
    fun retrieveCharacterList(): Single<List<RMCharacter>> =
        apiManager.retrieveCharacterList().map {
            it.map { characterRemoteEntity ->
                RMCharacter(
                    characterRemoteEntity.id,
                    characterRemoteEntity.name,
                    null,
                    null,
                    characterRemoteEntity.type,
                    null,
                    null,
                    null,
                    null,
                    characterRemoteEntity.image
                    )
            }
        }

    fun retrieveCharacterDetailsById(id: String): Single<RMCharacter> =
        apiManager.retrieveCharacterDetailsById(id).map {

                characterRemoteEntity ->
            RMCharacter(
                null,
                characterRemoteEntity.name,
                characterRemoteEntity.status,
                characterRemoteEntity.species,
                characterRemoteEntity.type,
                characterRemoteEntity.gender,
                characterRemoteEntity.origin,
                characterRemoteEntity.location,
                characterRemoteEntity.episode,
                characterRemoteEntity.image

            )

        }
}