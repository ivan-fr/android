package com.wayoukiss.android.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/wayoukiss/android/data/local/WayouKissDatabase;", "Landroidx/room/RoomDatabase;", "()V", "chatDao", "Lcom/wayoukiss/android/data/local/dao/ChatDao;", "matchDao", "Lcom/wayoukiss/android/data/local/dao/MatchDao;", "profileDao", "Lcom/wayoukiss/android/data/local/dao/ProfileDao;", "app_release"})
@androidx.room.Database(entities = {com.wayoukiss.android.data.local.entity.ProfileEntity.class, com.wayoukiss.android.data.local.entity.MatchEntity.class, com.wayoukiss.android.data.local.entity.ChatEntity.class, com.wayoukiss.android.data.local.entity.MessageEntity.class}, version = 1, exportSchema = true)
@androidx.room.TypeConverters(value = {com.wayoukiss.android.data.local.converter.DateConverter.class, com.wayoukiss.android.data.local.converter.UUIDConverter.class, com.wayoukiss.android.data.local.converter.ListConverter.class})
public abstract class WayouKissDatabase extends androidx.room.RoomDatabase {
    
    public WayouKissDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.wayoukiss.android.data.local.dao.ProfileDao profileDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.wayoukiss.android.data.local.dao.MatchDao matchDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.wayoukiss.android.data.local.dao.ChatDao chatDao();
}