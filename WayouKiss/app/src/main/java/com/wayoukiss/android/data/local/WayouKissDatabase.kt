package com.wayoukiss.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wayoukiss.android.data.local.converters.DateConverter
import com.wayoukiss.android.data.local.converters.UUIDConverter
import com.wayoukiss.android.data.local.dao.ChatDao
import com.wayoukiss.android.data.local.dao.MatchDao
import com.wayoukiss.android.data.local.dao.ProfileDao
import com.wayoukiss.android.data.local.entity.ChatMessageEntity
import com.wayoukiss.android.data.local.entity.ChatRoomEntity
import com.wayoukiss.android.data.local.entity.MatchEntity
import com.wayoukiss.android.data.local.entity.ProfileEntity

@Database(
    entities = [
        ProfileEntity::class,
        MatchEntity::class,
        ChatRoomEntity::class,
        ChatMessageEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class WayouKissDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    abstract fun matchDao(): MatchDao
    abstract fun chatDao(): ChatDao
}
