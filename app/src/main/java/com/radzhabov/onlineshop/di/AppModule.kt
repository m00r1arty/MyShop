package com.radzhabov.onlineshop.di

import com.radzhabov.onlineshop.data.db.AppDatabase
import com.radzhabov.onlineshop.data.db.UserDao
import com.radzhabov.onlineshop.presentation.viewmodels.AuthViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule{

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    fun provideAuthViewModel(userDao: UserDao): AuthViewModel {
        return AuthViewModel(userDao)
    }

}