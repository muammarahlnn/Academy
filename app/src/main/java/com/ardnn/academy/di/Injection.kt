package com.ardnn.academy.di

import android.content.Context
import com.ardnn.academy.data.AcademyRepository
import com.ardnn.academy.data.source.local.LocalDataSource
import com.ardnn.academy.data.source.local.room.AcademyDatabase
import com.ardnn.academy.data.source.remote.RemoteDataSource
import com.ardnn.academy.utils.AppExecutors
import com.ardnn.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {
        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}