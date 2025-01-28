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
    tableName = "messages",
    foreignKeys = [
        ForeignKey(
            entity = ChatEntity::class,
            parentColumns = ["id"],
            childColumns = ["chatId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProfileEntity::class,
            parentColumns = ["id"],
            childColumns = ["senderId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["chatId"]),
        Index(value = ["senderId"])
    ]
)
@TypeConverters(DateConverter::class, UUIDConverter::class)
data class MessageEntity(
    @PrimaryKey
    val id: UUID,
    val chatId: UUID,
    val senderId: UUID,
    val content: String,
    val timestamp: Date,
    val isRead: Boolean,
    val createdAt: Date,
    val updatedAt: Date
)
