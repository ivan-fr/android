package com.wayoukiss.android.data.local.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u000bH\u00c6\u0003J\t\u0010 \u001a\u00020\tH\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tH\u00c6\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020&H\u00d6\u0001J\t\u0010\'\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014\u00a8\u0006("}, d2 = {"Lcom/wayoukiss/android/data/local/entity/MessageEntity;", "", "id", "Ljava/util/UUID;", "chatId", "senderId", "content", "", "timestamp", "Ljava/util/Date;", "isRead", "", "createdAt", "updatedAt", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;Ljava/util/Date;ZLjava/util/Date;Ljava/util/Date;)V", "getChatId", "()Ljava/util/UUID;", "getContent", "()Ljava/lang/String;", "getCreatedAt", "()Ljava/util/Date;", "getId", "()Z", "getSenderId", "getTimestamp", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "messages", foreignKeys = {@androidx.room.ForeignKey(entity = com.wayoukiss.android.data.local.entity.ChatEntity.class, parentColumns = {"id"}, childColumns = {"chatId"}, onDelete = 5), @androidx.room.ForeignKey(entity = com.wayoukiss.android.data.local.entity.ProfileEntity.class, parentColumns = {"id"}, childColumns = {"senderId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"chatId"}), @androidx.room.Index(value = {"senderId"})})
@androidx.room.TypeConverters(value = {com.wayoukiss.android.data.local.converter.DateConverter.class, com.wayoukiss.android.data.local.converter.UUIDConverter.class})
public final class MessageEntity {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID id = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID chatId = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID senderId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String content = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date timestamp = null;
    private final boolean isRead = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date createdAt = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date updatedAt = null;
    
    public MessageEntity(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.UUID chatId, @org.jetbrains.annotations.NotNull
    java.util.UUID senderId, @org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    java.util.Date timestamp, boolean isRead, @org.jetbrains.annotations.NotNull
    java.util.Date createdAt, @org.jetbrains.annotations.NotNull
    java.util.Date updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getChatId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getSenderId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getTimestamp() {
        return null;
    }
    
    public final boolean isRead() {
        return false;
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
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
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
    public final java.util.Date component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.local.entity.MessageEntity copy(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.UUID chatId, @org.jetbrains.annotations.NotNull
    java.util.UUID senderId, @org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    java.util.Date timestamp, boolean isRead, @org.jetbrains.annotations.NotNull
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