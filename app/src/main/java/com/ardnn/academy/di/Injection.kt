package com.ardnn.academy.di

import android.content.Context
import com.ardnn.academy.data.AcademyRepository
import com.ardnn.academy.data.source.remote.RemoteDataSource
import com.ardnn.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return AcademyRepository.getInstance(remoteDataSource)
    }
}