package com.wayoukiss.android.data.local.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\'B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\fH\u00c6\u0003JQ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006("}, d2 = {"Lcom/wayoukiss/android/data/local/entity/ChatMessageEntity;", "", "id", "Ljava/util/UUID;", "roomId", "senderId", "content", "", "sentAt", "Ljava/util/Date;", "readAt", "type", "Lcom/wayoukiss/android/data/local/entity/ChatMessageEntity$MessageType;", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Lcom/wayoukiss/android/data/local/entity/ChatMessageEntity$MessageType;)V", "getContent", "()Ljava/lang/String;", "getId", "()Ljava/util/UUID;", "getReadAt", "()Ljava/util/Date;", "getRoomId", "getSenderId", "getSentAt", "getType", "()Lcom/wayoukiss/android/data/local/entity/ChatMessageEntity$MessageType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "MessageType", "app_release"})
@androidx.room.Entity(tableName = "chat_messages", foreignKeys = {@androidx.room.ForeignKey(entity = com.wayoukiss.android.data.local.entity.ChatRoomEntity.class, parentColumns = {"id"}, childColumns = {"roomId"}, onDelete = 5), @androidx.room.ForeignKey(entity = com.wayoukiss.android.data.local.entity.ProfileEntity.class, parentColumns = {"id"}, childColumns = {"senderId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"roomId"}), @androidx.room.Index(value = {"senderId"})})
public final class ChatMessageEntity {
    @androidx.room.PrimaryKey
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID id = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID roomId = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.UUID senderId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String content = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.Date sentAt = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.Date readAt = null;
    @org.jetbrains.annotations.NotNull
    private final com.wayoukiss.android.data.local.entity.ChatMessageEntity.MessageType type = null;
    
    public ChatMessageEntity(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.UUID roomId, @org.jetbrains.annotations.NotNull
    java.util.UUID senderId, @org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    java.util.Date sentAt, @org.jetbrains.annotations.Nullable
    java.util.Date readAt, @org.jetbrains.annotations.NotNull
    com.wayoukiss.android.data.local.entity.ChatMessageEntity.MessageType type) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID getRoomId() {
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
    public final java.util.Date getSentAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date getReadAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.local.entity.ChatMessageEntity.MessageType getType() {
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
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Date component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.local.entity.ChatMessageEntity.MessageType component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.local.entity.ChatMessageEntity copy(@org.jetbrains.annotations.NotNull
    java.util.UUID id, @org.jetbrains.annotations.NotNull
    java.util.UUID roomId, @org.jetbrains.annotations.NotNull
    java.util.UUID senderId, @org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    java.util.Date sentAt, @org.jetbrains.annotations.Nullable
    java.util.Date readAt, @org.jetbrains.annotations.NotNull
    com.wayoukiss.android.data.local.entity.ChatMessageEntity.MessageType type) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/wayoukiss/android/data/local/entity/ChatMessageEntity$MessageType;", "", "(Ljava/lang/String;I)V", "TEXT", "IMAGE", "SYSTEM", "app_release"})
    public static enum MessageType {
        /*public static final*/ TEXT /* = new TEXT() */,
        /*public static final*/ IMAGE /* = new IMAGE() */,
        /*public static final*/ SYSTEM /* = new SYSTEM() */;
        
        MessageType() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.wayoukiss.android.data.local.entity.ChatMessageEntity.MessageType> getEntries() {
            return null;
        }
    }
}