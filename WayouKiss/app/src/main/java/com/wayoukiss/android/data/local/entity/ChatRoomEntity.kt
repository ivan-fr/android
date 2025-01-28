package com.wayoukiss.android.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(
    tableName = "chat_rooms",
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
data class ChatRoomEntity(
    @PrimaryKey
    val id: UUID,
    val matchId: UUID,
    val lastMessage: String?,
    val lastMessageTime: Date?,
    val unreadCount: Int,
    val createdAt: Date
)
