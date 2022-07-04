package com.example.checkinghomework.di.module

import android.content.Context
import androidx.room.Room
import com.example.checkinghomework.data.remote.IRetrofitApi
import com.example.checkinghomework.data.repository.news.NewsRepository
import com.example.checkinghomework.db.CheckingDatabase
import com.example.checkinghomework.db.IUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase (@ApplicationContext appContext: Context): CheckingDatabase{
        return Room.databaseBuilder (
            appContext,
            CheckingDatabase::class.java, "database"
        )
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideUsersDao(appDatabase: CheckingDatabase): IUserDao {
        return appDatabase.usersDao()!!
    }

}