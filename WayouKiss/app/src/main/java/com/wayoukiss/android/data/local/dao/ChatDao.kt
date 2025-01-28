package com.wayoukiss.android.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.wayoukiss.android.data.local.entity.ChatMessageEntity
import com.wayoukiss.android.data.local.entity.ChatRoomEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface ChatDao : BaseDao<ChatRoomEntity> {

    @Query(
        "SELECT * FROM chat_rooms " +
        "ORDER BY lastMessageTime DESC"
    )
    fun getChatRooms(): Flow<List<ChatRoomEntity>>

    @Query(
        "SELECT * FROM chat_rooms " +
        "WHERE id = :roomId"
    )
    fun getChatRoom(roomId: UUID): Flow<ChatRoomEntity?>

    @Query(
        "SELECT * FROM chat_messages " +
        "WHERE roomId = :roomId " +
        "ORDER BY sentAt DESC"
    )
    fun getMessages(roomId: UUID): PagingSource<Int, ChatMessageEntity>

    @Query(
        "UPDATE chat_messages " +
        "SET readAt = :readAt " +
        "WHERE roomId = :roomId " +
        "AND senderId != :currentUserId " +
        "AND readAt IS NULL"
    )
    suspend fun markMessagesAsRead(
        roomId: UUID,
        currentUserId: UUID,
        readAt: Long
    )

    @Transaction
    suspend fun insertMessage(
        message: ChatMessageEntity,
        updateRoom: ChatRoomEntity
    ) {
        insert(message)
        update(updateRoom)
    }

    @Query(
        "SELECT COUNT(*) FROM chat_messages " +
        "WHERE roomId = :roomId " +
        "AND senderId != :currentUserId " +
        "AND readAt IS NULL"
    )
    fun getUnreadCount(
        roomId: UUID,
        currentUserId: UUID
    ): Flow<Int>

    @Query(
        "DELETE FROM chat_messages " +
        "WHERE roomId = :roomId"
    )
    suspend fun clearMessages(roomId: UUID)
}
