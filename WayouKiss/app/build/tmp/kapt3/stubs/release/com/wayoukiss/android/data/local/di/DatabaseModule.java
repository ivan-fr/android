package com.wayoukiss.android.data.local.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/wayoukiss/android/data/local/di/DatabaseModule;", "", "()V", "provideAppDatabase", "error/NonExistentClass", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Lerror/NonExistentClass;", "provideChatDao", "Lcom/wayoukiss/android/data/local/dao/ChatDao;", "database", "(Lerror/NonExistentClass;)Lcom/wayoukiss/android/data/local/dao/ChatDao;", "provideMatchDao", "Lcom/wayoukiss/android/data/local/dao/MatchDao;", "(Lerror/NonExistentClass;)Lcom/wayoukiss/android/data/local/dao/MatchDao;", "provideProfileDao", "Lcom/wayoukiss/android/data/local/dao/ProfileDao;", "(Lerror/NonExistentClass;)Lcom/wayoukiss/android/data/local/dao/ProfileDao;", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull
    public static final com.wayoukiss.android.data.local.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final error.NonExistentClass provideAppDatabase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.local.dao.ChatDao provideChatDao(@org.jetbrains.annotations.NotNull
    error.NonExistentClass database) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.local.dao.MatchDao provideMatchDao(@org.jetbrains.annotations.NotNull
    error.NonExistentClass database) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.local.dao.ProfileDao provideProfileDao(@org.jetbrains.annotations.NotNull
    error.NonExistentClass database) {
        return null;
    }
}