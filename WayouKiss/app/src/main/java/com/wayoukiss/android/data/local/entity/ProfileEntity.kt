package com.wayoukiss.android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "profiles")
data class ProfileEntity(
    @PrimaryKey
    val id: UUID,
    val name: String,
    val bio: String?,
    val birthDate: Date,
    val photos: List<String>,
    val lastActive: Date,
    val isOnline: Boolean,
    val location: String?,
    val interests: List<String>,
    val createdAt: Date,
    val updatedAt: Date
)
