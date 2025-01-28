package com.wayoukiss.android.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\u0005H\'J$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/wayoukiss/android/data/local/dao/MatchDao;", "", "deleteMatch", "", "matchId", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMatches", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/wayoukiss/android/data/local/entity/MatchEntity;", "userId", "getMatchesByStatus", "isActive", "", "app_release"})
@androidx.room.Dao
public abstract interface MatchDao {
    
    @androidx.room.Query(value = "\n        SELECT * FROM matches \n        WHERE user1Id = :userId OR user2Id = :userId \n        ORDER BY matchedAt DESC\n        ")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.wayoukiss.android.data.local.entity.MatchEntity>> getMatches(@org.jetbrains.annotations.NotNull
    java.util.UUID userId);
    
    @androidx.room.Query(value = "\n        SELECT * FROM matches \n        WHERE (user1Id = :userId OR user2Id = :userId) \n        AND isActive = :isActive \n        ORDER BY matchedAt DESC\n        ")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.wayoukiss.android.data.local.entity.MatchEntity>> getMatchesByStatus(@org.jetbrains.annotations.NotNull
    java.util.UUID userId, boolean isActive);
    
    @androidx.room.Query(value = "DELETE FROM matches WHERE id = :matchId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteMatch(@org.jetbrains.annotations.NotNull
    java.util.UUID matchId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}