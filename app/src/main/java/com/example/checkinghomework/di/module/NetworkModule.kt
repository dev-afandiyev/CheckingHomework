package com.example.checkinghomework.di.module

import com.example.checkinghomework.constants.Constants.BASE_URL
import com.example.checkinghomework.data.remote.IRetrofitApi
import com.example.checkinghomework.data.repository.news.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @ViewModelScoped
    @Provides
    fun provideRetrofitApi(): IRetrofitApi {
        val okHttpClient = OkHttpClient()
            .newBuilder()
            .build()

        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IRetrofitApi::class.java)
    }

    @ViewModelScoped
    @Provides
    fun provideNewsRepository(
        api: IRetrofitApi
    ): NewsRepository {
        return NewsRepository(api)
    }

}