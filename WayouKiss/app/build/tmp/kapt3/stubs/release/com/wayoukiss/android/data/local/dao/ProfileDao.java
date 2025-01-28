package com.wayoukiss.android.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\rH\'J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\r2\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0010"}, d2 = {"Lcom/wayoukiss/android/data/local/dao/ProfileDao;", "", "deleteProfileById", "", "profileId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProfileById", "Lcom/wayoukiss/android/data/local/entity/ProfileEntity;", "insertProfile", "profile", "(Lcom/wayoukiss/android/data/local/entity/ProfileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAllProfiles", "Lkotlinx/coroutines/flow/Flow;", "", "observeProfileById", "app_release"})
@androidx.room.Dao
public abstract interface ProfileDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertProfile(@org.jetbrains.annotations.NotNull
    com.wayoukiss.android.data.local.entity.ProfileEntity profile, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM profiles WHERE id = :profileId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getProfileById(@org.jetbrains.annotations.NotNull
    java.lang.String profileId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wayoukiss.android.data.local.entity.ProfileEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM profiles WHERE id = :profileId")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.wayoukiss.android.data.local.entity.ProfileEntity> observeProfileById(@org.jetbrains.annotations.NotNull
    java.lang.String profileId);
    
    @androidx.room.Query(value = "SELECT * FROM profiles")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.wayoukiss.android.data.local.entity.ProfileEntity>> observeAllProfiles();
    
    @androidx.room.Query(value = "DELETE FROM profiles WHERE id = :profileId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteProfileById(@org.jetbrains.annotations.NotNull
    java.lang.String profileId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}