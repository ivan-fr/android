package com.wayoukiss.android.data.repositories;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u000e\u0010\f\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/wayoukiss/android/data/repositories/AuthRepositoryImpl;", "Lcom/wayoukiss/android/domain/repositories/AuthRepository;", "api", "Lcom/wayoukiss/android/data/api/AuthApi;", "tokenManager", "Lcom/wayoukiss/android/core/security/TokenManager;", "(Lcom/wayoukiss/android/data/api/AuthApi;Lcom/wayoukiss/android/core/security/TokenManager;)V", "getAccessToken", "", "observeAuthState", "Lkotlinx/coroutines/flow/Flow;", "", "refreshToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInWithGoogle", "Lcom/wayoukiss/android/domain/models/AuthResult;", "idToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "", "app_release"})
public final class AuthRepositoryImpl implements com.wayoukiss.android.domain.repositories.AuthRepository {
    @org.jetbrains.annotations.NotNull
    private final com.wayoukiss.android.data.api.AuthApi api = null;
    @org.jetbrains.annotations.NotNull
    private final com.wayoukiss.android.core.security.TokenManager tokenManager = null;
    
    @javax.inject.Inject
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.wayoukiss.android.data.api.AuthApi api, @org.jetbrains.annotations.NotNull
    com.wayoukiss.android.core.security.TokenManager tokenManager) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object signInWithGoogle(@org.jetbrains.annotations.NotNull
    java.lang.String idToken, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wayoukiss.android.domain.models.AuthResult> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object signOut(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> observeAuthState() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.String getAccessToken() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object refreshToken(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}