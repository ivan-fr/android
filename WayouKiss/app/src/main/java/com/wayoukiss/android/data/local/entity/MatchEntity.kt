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
    tableName = "matches",
    foreignKeys = [
        ForeignKey(
            entity = ProfileEntity::class,
            parentColumns = ["id"],
            childColumns = ["user1Id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProfileEntity::class,
            parentColumns = ["id"],
            childColumns = ["user2Id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["user1Id"]),
        Index(value = ["user2Id"])
    ]
)
@TypeConverters(DateConverter::class, UUIDConverter::class)
data class MatchEntity(
    @PrimaryKey
    val id: UUID,
    val user1Id: UUID,
    val user2Id: UUID,
    val matchedAt: Date,
    val lastInteractionAt: Date,
    val isActive: Boolean
)
