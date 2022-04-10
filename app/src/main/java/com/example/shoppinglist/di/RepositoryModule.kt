package com.example.shoppinglist.di

import com.example.shoppinglist.network.NetworkService
import com.example.shoppinglist.persistence.ProductDao
import com.example.shoppinglist.ui.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        networkService: NetworkService,
        productDao: ProductDao
    ) = MainRepository(networkService, productDao)
}