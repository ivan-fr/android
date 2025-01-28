package com.wayoukiss.android.data.local.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\nH\u00d6\u0001J\t\u0010\"\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/wayoukiss/android/data/local/entity/ChatRoomEntity;", "", "id", "Ljava/util/UUID;", "matchId", "lastMessage", "", "lastMessageTime", "Ljava/util/Date;", "unreadCount", "", "createdAt", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;Ljava/util/Date;ILjava/util/Date;)V", "getCreatedAt", "()Ljava/util/Date;", "getId", "()Ljava/util/UUID;", "getLastMessage", "()Ljava/lang/String;", "getLastMessageTime", "getMatchId", "getUnreadCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_release"})
@androidx.room.Entity(tableName = "chat_rooms", foreignKeys = {@androidx.room.ForeignKey(entity = com.wayoukiss.android.data.local.entity.MatchEntity.class, parentColumns = {"id"}, childColumns = {"matchId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"matchId"})})
public final class ChatRoomEntity {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID id = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID matchId = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String lastMessage = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.Date lastMessageTime = null;
    private final int unreadCount = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date createdAt = null;
    
    public ChatRoomEntity(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.UUID matchId, @org.jetbrains.annotations.Nullable
    java.lang.String lastMessage, @org.jetbrains.annotations.Nullable
    java.util.Date lastMessageTime, int unreadCount, @org.jetbrains.annotations.NotNull
    java.util.Date createdAt) {
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
    public final java.lang.String getLastMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date getLastMessageTime() {
        return null;
    }
    
    public final int getUnreadCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getCreatedAt() {
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
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.local.entity.ChatRoomEntity copy(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.UUID matchId, @org.jetbrains.annotations.Nullable
    java.lang.String lastMessage, @org.jetbrains.annotations.Nullable
    java.util.Date lastMessageTime, int unreadCount, @org.jetbrains.annotations.NotNull
    java.util.Date createdAt) {
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