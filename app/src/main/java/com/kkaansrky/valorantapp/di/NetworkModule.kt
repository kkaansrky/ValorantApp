package com.kkaansrky.valorantapp.di

import com.google.gson.Gson
import com.kkaansrky.valorantapp.data.remote.ApiService
import com.kkaansrky.valorantapp.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRetrofit(
        gson: Gson,
        endPoint: EndPoint
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endPoint.url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideRemoteDataSource(
        apiService: ApiService,
    ): RemoteDataSource {
        return RemoteDataSource(apiService)
    }

    @Provides
    fun provideEndPoint(): EndPoint {
        return EndPoint("https://valorant-api.com/v1/")
    }
}

data class EndPoint(val url: String)