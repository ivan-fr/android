package com.wayoukiss.android.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.wayoukiss.android.data.local.converter.DateConverter
import com.wayoukiss.android.data.local.converter.UUIDConverter
import java.util.Date
import java.util.UUID

@Entity(
    tableName = "chats",
    foreignKeys = [
        ForeignKey(
            entity = MatchEntity::class,
            parentColumns = ["id"],
            childColumns = ["matchId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["matchId"])]
)
@TypeConverters(DateConverter::class, UUIDConverter::class)
data class ChatEntity(
    @PrimaryKey
    val id: UUID,
    val matchId: UUID,
    val lastMessageAt: Date?,
    val createdAt: Date,
    val updatedAt: Date
)
