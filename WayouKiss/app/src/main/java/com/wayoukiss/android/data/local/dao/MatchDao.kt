package com.wayoukiss.android.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.wayoukiss.android.data.local.entity.MatchEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface MatchDao {
    @Query(
        """
        SELECT * FROM matches 
        WHERE user1Id = :userId OR user2Id = :userId 
        ORDER BY matchedAt DESC
        """
    )
    fun getMatches(userId: UUID): Flow<List<MatchEntity>>

    @Query(
        """
        SELECT * FROM matches 
        WHERE (user1Id = :userId OR user2Id = :userId) 
        AND isActive = :isActive 
        ORDER BY matchedAt DESC
        """
    )
    fun getMatchesByStatus(
        userId: UUID,
        isActive: Boolean
    ): Flow<List<MatchEntity>>

    @Query("DELETE FROM matches WHERE id = :matchId")
    suspend fun deleteMatch(matchId: UUID)
}
