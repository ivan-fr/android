package com.wayoukiss.android.data.local.di

import android.content.Context
import androidx.room.Room
import com.wayoukiss.android.data.local.AppDatabase
import com.wayoukiss.android.data.local.dao.ChatDao
import com.wayoukiss.android.data.local.dao.MatchDao
import com.wayoukiss.android.data.local.dao.ProfileDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "wayoukiss.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideChatDao(database: AppDatabase): ChatDao {
        return database.chatDao()
    }

    @Provides
    @Singleton
    fun provideMatchDao(database: AppDatabase): MatchDao {
        return database.matchDao()
    }

    @Provides
    @Singleton
    fun provideProfileDao(database: AppDatabase): ProfileDao {
        return database.profileDao()
    }
}
