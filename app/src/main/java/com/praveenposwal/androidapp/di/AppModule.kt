package com.praveenposwal.androidapp.di

import android.app.Application
import androidx.room.Room
import com.praveenposwal.androidapp.data.api.ApiService
import com.praveenposwal.androidapp.data.db.AppDatabase
import com.praveenposwal.androidapp.data.db.PostDao
import com.praveenposwal.androidapp.data.repository.AuthRepositoryImpl
import com.praveenposwal.androidapp.data.repository.PostRepositoryImpl
import com.praveenposwal.androidapp.domain.repository.AuthRepository
import com.praveenposwal.androidapp.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providePostDao(db: AppDatabase): PostDao {
        return db.postDao()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePostRepository(
        apiService: ApiService,
        postDao: PostDao
    ): PostRepository {
        return PostRepositoryImpl(apiService, postDao)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository {
        return authRepositoryImpl
    }
}
