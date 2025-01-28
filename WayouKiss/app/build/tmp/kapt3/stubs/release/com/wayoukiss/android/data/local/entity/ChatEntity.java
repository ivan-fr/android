package com.wayoukiss.android.data.local.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001e"}, d2 = {"Lcom/wayoukiss/android/data/local/entity/ChatEntity;", "", "id", "Ljava/util/UUID;", "matchId", "lastMessageAt", "Ljava/util/Date;", "createdAt", "updatedAt", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;)V", "getCreatedAt", "()Ljava/util/Date;", "getId", "()Ljava/util/UUID;", "getLastMessageAt", "getMatchId", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"})
@androidx.room.Entity(tableName = "chats", foreignKeys = {@androidx.room.ForeignKey(entity = com.wayoukiss.android.data.local.entity.MatchEntity.class, parentColumns = {"id"}, childColumns = {"matchId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"matchId"})})
@androidx.room.TypeConverters(value = {com.wayoukiss.android.data.local.converter.DateConverter.class, com.wayoukiss.android.data.local.converter.UUIDConverter.class})
public final class ChatEntity {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID id = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID matchId = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.Date lastMessageAt = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date createdAt = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date updatedAt = null;
    
    public ChatEntity(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.UUID matchId, @org.jetbrains.annotations.Nullable
    java.util.Date lastMessageAt, @org.jetbrains.annotations.NotNull
    java.util.Date createdAt, @org.jetbrains.annotations.NotNull
    java.util.Date updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getMatchId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date getLastMessageAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getUpdatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date component3() {
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
    
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.local.entity.ChatEntity copy(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.UUID matchId, @org.jetbrains.annotations.Nullable
    java.util.Date lastMessageAt, @org.jetbrains.annotations.NotNull
    java.util.Date createdAt, @org.jetbrains.annotations.NotNull
    java.util.Date updatedAt) {
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