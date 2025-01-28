package com.wayoukiss.android.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/wayoukiss/android/data/api/AuthApi;", "", "refreshToken", "Lcom/wayoukiss/android/data/api/AuthResponse;", "request", "Lcom/wayoukiss/android/data/api/RefreshTokenRequest;", "(Lcom/wayoukiss/android/data/api/RefreshTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInWithGoogle", "Lcom/wayoukiss/android/data/api/GoogleSignInRequest;", "(Lcom/wayoukiss/android/data/api/GoogleSignInRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AuthApi {
    
    @retrofit2.http.POST(value = "auth/google")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object signInWithGoogle(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.wayoukiss.android.data.api.GoogleSignInRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wayoukiss.android.data.api.AuthResponse> $completion);
    
    @retrofit2.http.POST(value = "auth/refresh")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object refreshToken(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.wayoukiss.android.data.api.RefreshTokenRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wayoukiss.android.data.api.AuthResponse> $completion);
}