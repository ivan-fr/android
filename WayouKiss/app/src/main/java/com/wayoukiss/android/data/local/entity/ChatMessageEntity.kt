package com.wayoukiss.android.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(
    tableName = "chat_messages",
    foreignKeys = [
        ForeignKey(
            entity = ChatRoomEntity::class,
            parentColumns = ["id"],
            childColumns = ["roomId"],
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
        Index(value = ["roomId"]),
        Index(value = ["senderId"])
    ]
)
data class ChatMessageEntity(
    @PrimaryKey
    val id: UUID,
    val roomId: UUID,
    val senderId: UUID,
    val content: String,
    val sentAt: Date,
    val readAt: Date?,
    val type: MessageType
) {
    enum class MessageType {
        TEXT,
        IMAGE,
        SYSTEM
    }
}
