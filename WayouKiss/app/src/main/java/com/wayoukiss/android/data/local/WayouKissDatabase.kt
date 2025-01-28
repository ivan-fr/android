package com.wayoukiss.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wayoukiss.android.data.local.converter.DateConverter
import com.wayoukiss.android.data.local.converter.ListConverter
import com.wayoukiss.android.data.local.converter.UUIDConverter
import com.wayoukiss.android.data.local.dao.ChatDao
import com.wayoukiss.android.data.local.dao.MatchDao
import com.wayoukiss.android.data.local.dao.ProfileDao
import com.wayoukiss.android.data.local.entity.ChatEntity
import com.wayoukiss.android.data.local.entity.MatchEntity
import com.wayoukiss.android.data.local.entity.MessageEntity
import com.wayoukiss.android.data.local.entity.ProfileEntity

@Database(
    entities = [
        ProfileEntity::class,
        MatchEntity::class,
        ChatEntity::class,
        MessageEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(DateConverter::class, UUIDConverter::class, ListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    abstract fun matchDao(): MatchDao
    abstract fun chatDao(): ChatDao
}
