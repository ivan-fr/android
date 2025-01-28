package com.wayoukiss.android.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/wayoukiss/android/di/AuthModule;", "", "()V", "provideAuthApi", "Lcom/wayoukiss/android/data/api/AuthApi;", "retrofit", "Lretrofit2/Retrofit;", "provideAuthRepository", "Lcom/wayoukiss/android/domain/repositories/AuthRepository;", "authApi", "tokenManager", "error/NonExistentClass", "(Lcom/wayoukiss/android/data/api/AuthApi;Lerror/NonExistentClass;)Lcom/wayoukiss/android/domain/repositories/AuthRepository;", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AuthModule {
    @org.jetbrains.annotations.NotNull
    public static final com.wayoukiss.android.di.AuthModule INSTANCE = null;
    
    private AuthModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.data.api.AuthApi provideAuthApi(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.wayoukiss.android.domain.repositories.AuthRepository provideAuthRepository(@org.jetbrains.annotations.NotNull
    com.wayoukiss.android.data.api.AuthApi authApi, @org.jetbrains.annotations.NotNull
    error.NonExistentClass tokenManager) {
        return null;
    }
}