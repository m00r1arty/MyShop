package com.radzhabov.onlineshop.di

import android.content.Context
import com.radzhabov.onlineshop.data.db.AppDatabase
import com.radzhabov.onlineshop.data.db.UserDao
import com.radzhabov.onlineshop.data.network.service.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getInstance(appContext)

    @Provides
    @Singleton
    fun provideNetworkService() = NetworkService.getInstance()

    @Provides
    @Singleton
    fun provideFlashSalesApi(networkService: NetworkService) =
        networkService.flashSaleApi

    @Provides
    @Singleton
    fun latestApi(networkService: NetworkService) =
        networkService.latestApi

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

}