package com.wayoukiss.android.core.security;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\r\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/wayoukiss/android/core/security/TokenManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "masterKey", "Landroidx/security/crypto/MasterKey;", "sharedPreferences", "Landroid/content/SharedPreferences;", "clearTokens", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRefreshToken", "deleteToken", "getAccessToken", "", "getRefreshToken", "getToken", "Lkotlinx/coroutines/flow/Flow;", "getTokenBlocking", "saveRefreshToken", "refreshToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveToken", "accessToken", "saveTokens", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"})
public final class TokenManager {
    @org.jetbrains.annotations.NotNull
    private final androidx.security.crypto.MasterKey masterKey = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_ACCESS_TOKEN = "access_token";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_REFRESH_TOKEN = "refresh_token";
    @org.jetbrains.annotations.NotNull
    public static final com.wayoukiss.android.core.security.TokenManager.Companion Companion = null;
    
    @javax.inject.Inject
    public TokenManager(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveToken(@org.jetbrains.annotations.NotNull
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveRefreshToken(@org.jetbrains.annotations.NotNull
    java.lang.String refreshToken, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveTokens(@org.jetbrains.annotations.NotNull
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull
    java.lang.String refreshToken, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTokenBlocking() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAccessToken(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRefreshToken(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteToken(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteRefreshToken(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearTokens(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/wayoukiss/android/core/security/TokenManager$Companion;", "", "()V", "KEY_ACCESS_TOKEN", "", "KEY_REFRESH_TOKEN", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}