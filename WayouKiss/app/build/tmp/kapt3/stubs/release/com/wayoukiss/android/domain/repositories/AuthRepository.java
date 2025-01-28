package com.wayoukiss.android.domain.repositories;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u000e\u0010\u0007\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u00a6@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/wayoukiss/android/domain/repositories/AuthRepository;", "", "getAccessToken", "", "observeAuthState", "Lkotlinx/coroutines/flow/Flow;", "", "refreshToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInWithGoogle", "Lcom/wayoukiss/android/domain/models/AuthResult;", "idToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "", "app_release"})
public abstract interface AuthRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object signInWithGoogle(@org.jetbrains.annotations.NotNull
    java.lang.String idToken, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wayoukiss.android.domain.models.AuthResult> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object signOut(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> observeAuthState();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.String getAccessToken();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object refreshToken(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}