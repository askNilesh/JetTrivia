package com.asknilesh.jettrivia.di

import android.content.Context
import com.asknilesh.jettrivia.network.ApiService
import com.asknilesh.jettrivia.network.Constants.BASE_URL
import com.asknilesh.jettrivia.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


  @Provides
  @Singleton
  fun provideApiService(@ApplicationContext context: Context): ApiService {
    val retrofit = Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
    return retrofit.create(ApiService::class.java)
  }

  @Provides
  @Singleton
  fun providesQuestionRepository(apiService: ApiService) = QuestionRepository(apiService)

}