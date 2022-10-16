package com.tes.eat.anywhere.bottomnavigationapp.di

import com.tes.eat.anywhere.bottomnavigationapp.model.remote.bible.BibleApi
import com.tes.eat.anywhere.bottomnavigationapp.model.remote.bible.BibleApiDetails
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
    fun provideNewsApi(retrofit: Retrofit): NewsApi =retrofit.create(NewsApi::class.java)

    @Provides
    fun provideBibleApi(retrofit: Retrofit): BibleApi =retrofit
        .newBuilder()
        .baseUrl(BibleApiDetails.BASE_URL)
        .build()
        .create(BibleApi::class.java)

    @Provides
    fun provideRepository(
        newsApi: NewsApi,bibleApi:BibleApi
    ): Repository {
        return RepositoryImpl(newsApi,bibleApi)
    }

}
