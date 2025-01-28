package com.wayoukiss.android.data.local.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u00a8\u0006!"}, d2 = {"Lcom/wayoukiss/android/data/local/entity/MatchEntity;", "", "id", "Ljava/util/UUID;", "user1Id", "user2Id", "matchedAt", "Ljava/util/Date;", "lastInteractionAt", "isActive", "", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/util/Date;Ljava/util/Date;Z)V", "getId", "()Ljava/util/UUID;", "()Z", "getLastInteractionAt", "()Ljava/util/Date;", "getMatchedAt", "getUser1Id", "getUser2Id", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"})
@androidx.room.Entity(tableName = "matches", foreignKeys = {@androidx.room.ForeignKey(entity = com.wayoukiss.android.data.local.entity.ProfileEntity.class, parentColumns = {"id"}, childColumns = {"user1Id"}, onDelete = 5), @androidx.room.ForeignKey(entity = com.wayoukiss.android.data.local.entity.ProfileEntity.class, parentColumns = {"id"}, childColumns = {"user2Id"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"user1Id"}), @androidx.room.Index(value = {"user2Id"})})
@androidx.room.TypeConverters(value = {com.wayoukiss.android.data.local.converter.DateConverter.class, com.wayoukiss.android.data.local.converter.UUIDConverter.class})
public final class MatchEntity {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID id = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID user1Id = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID user2Id = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date matchedAt = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date lastInteractionAt = null;
    private final boolean isActive = false;
    
    public MatchEntity(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.UUID user1Id, @org.jetbrains.annotations.NotNull
    java.util.UUID user2Id, @org.jetbrains.annotations.NotNull
    java.util.Date matchedAt, @org.jetbrains.annotations.NotNull
    java.util.Date lastInteractionAt, boolean isActive) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getUser1Id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getUser2Id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getMatchedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getLastInteractionAt() {
        return null;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.local.entity.MatchEntity copy(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.UUID user1Id, @org.jetbrains.annotations.NotNull
    java.util.UUID user2Id, @org.jetbrains.annotations.NotNull
    java.util.Date matchedAt, @org.jetbrains.annotations.NotNull
    java.util.Date lastInteractionAt, boolean isActive) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}