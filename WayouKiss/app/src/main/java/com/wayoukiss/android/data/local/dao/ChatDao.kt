package com.wayoukiss.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.wayoukiss.android.data.local.entity.ChatEntity
import com.wayoukiss.android.data.local.entity.ChatWithMessages
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChat(chat: ChatEntity)

    @Query("SELECT * FROM chats")
    fun observeAllChats(): Flow<List<ChatEntity>>

    @Query("SELECT * FROM chats WHERE id = :chatId")
    suspend fun getChatById(chatId: String): ChatEntity?

    @Transaction
    @Query(
        """
        SELECT c.* FROM chats c 
        INNER JOIN messages m ON c.id = m.chatId 
        WHERE m.timestamp > :timestamp
        GROUP BY c.id
        """
    )
    fun observeChatsWithRecentMessages(
        timestamp: Long
    ): Flow<List<ChatWithMessages>>

    @Transaction
    @Query(
        """
        SELECT c.* FROM chats c 
        LEFT JOIN messages m ON c.id = m.chatId 
        GROUP BY c.id
        """
    )
    fun observeChatsWithMessages(): Flow<List<ChatWithMessages>>

    @Query("DELETE FROM chats WHERE id = :chatId")
    suspend fun deleteChatById(chatId: String)
}
