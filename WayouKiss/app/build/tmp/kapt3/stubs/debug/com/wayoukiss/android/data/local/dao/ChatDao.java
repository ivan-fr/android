package com.wayoukiss.android.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\rH\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000e0\rH\'J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u0013H\'\u00a8\u0006\u0014"}, d2 = {"Lcom/wayoukiss/android/data/local/dao/ChatDao;", "", "deleteChatById", "", "chatId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChatById", "Lcom/wayoukiss/android/data/local/entity/ChatEntity;", "insertChat", "chat", "(Lcom/wayoukiss/android/data/local/entity/ChatEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAllChats", "Lkotlinx/coroutines/flow/Flow;", "", "observeChatsWithMessages", "Lcom/wayoukiss/android/data/local/entity/ChatWithMessages;", "observeChatsWithRecentMessages", "timestamp", "", "app_debug"})
@androidx.room.Dao
public abstract interface ChatDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertChat(@org.jetbrains.annotations.NotNull
    com.wayoukiss.android.data.local.entity.ChatEntity chat, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM chats")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.wayoukiss.android.data.local.entity.ChatEntity>> observeAllChats();
    
    @androidx.room.Query(value = "SELECT * FROM chats WHERE id = :chatId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getChatById(@org.jetbrains.annotations.NotNull
    java.lang.String chatId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wayoukiss.android.data.local.entity.ChatEntity> $completion);
    
    @androidx.room.Transaction
    @androidx.room.Query(value = "\n        SELECT c.* FROM chats c \n        INNER JOIN messages m ON c.id = m.chatId \n        WHERE m.timestamp > :timestamp\n        GROUP BY c.id\n        ")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.wayoukiss.android.data.local.entity.ChatWithMessages>> observeChatsWithRecentMessages(long timestamp);
    
    @androidx.room.Transaction
    @androidx.room.Query(value = "\n        SELECT c.* FROM chats c \n        LEFT JOIN messages m ON c.id = m.chatId \n        GROUP BY c.id\n        ")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.wayoukiss.android.data.local.entity.ChatWithMessages>> observeChatsWithMessages();
    
    @androidx.room.Query(value = "DELETE FROM chats WHERE id = :chatId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteChatById(@org.jetbrains.annotations.NotNull
    java.lang.String chatId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}