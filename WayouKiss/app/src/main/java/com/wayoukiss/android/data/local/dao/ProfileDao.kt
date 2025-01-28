package com.wayoukiss.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wayoukiss.android.data.local.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: ProfileEntity)

    @Query("SELECT * FROM profiles WHERE id = :profileId")
    suspend fun getProfileById(profileId: String): ProfileEntity?

    @Query("SELECT * FROM profiles WHERE id = :profileId")
    fun observeProfileById(profileId: String): Flow<ProfileEntity?>

    @Query("SELECT * FROM profiles")
    fun observeAllProfiles(): Flow<List<ProfileEntity>>

    @Query("DELETE FROM profiles WHERE id = :profileId")
    suspend fun deleteProfileById(profileId: String)
}
