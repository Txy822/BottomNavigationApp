package com.tes.eat.anywhere.bottomnavigationapp.di

import com.tes.eat.anywhere.bottomnavigationapp.model.remote.news.NewsApi
import com.tes.eat.anywhere.bottomnavigationapp.model.remote.news.NewsApiDetails
import com.tes.eat.anywhere.bottomnavigationapp.model.repository.Repository
import com.tes.eat.anywhere.bottomnavigationapp.model.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class) //to define the scope of dependancy injection
class AppModule {
    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(NewsApiDetails.BASE_URL)
        .build()

    @Provides
    fun provideNewsAPI(retrofit: Retrofit): NewsApi =retrofit.create(NewsApi::class.java)


    @Provides
    fun provideRepository(
        newsApi: NewsApi
    ): Repository {
        return RepositoryImpl(newsApi)
    }

}
