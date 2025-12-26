package com.example.apimodule.network.repository

import com.example.data.repository.TeamsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTeamsRepository(
        impl: TeamsRepositoryImpl
    ): TeamsRepository
}