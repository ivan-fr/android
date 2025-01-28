package com.wayoukiss.android.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.wayoukiss.android.data.local.entity.MatchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {
    @Query(
        """
        SELECT * FROM matches 
        WHERE userId = :userId 
        ORDER BY matchTime DESC
        """
    )
    fun getMatches(userId: String): Flow<List<MatchEntity>>

    @Query(
        """
        SELECT * FROM matches 
        WHERE userId = :userId AND status = :status 
        ORDER BY matchTime DESC
        """
    )
    fun getMatchesByStatus(
        userId: String,
        status: String
    ): Flow<List<MatchEntity>>

    @Query("DELETE FROM matches WHERE id = :matchId")
    suspend fun deleteMatch(matchId: String)
}
