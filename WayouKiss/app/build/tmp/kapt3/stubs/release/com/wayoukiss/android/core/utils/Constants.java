package com.wayoukiss.android.core.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/wayoukiss/android/core/utils/Constants;", "", "()V", "BASE_URL", "", "BIOMETRIC_TIMEOUT", "", "CACHE_MAX_AGE", "CACHE_SIZE", "", "IMAGE_QUALITY", "MAX_IMAGES_PER_PROFILE", "MAX_IMAGE_SIZE", "MAX_RETRIES", "NETWORK_TIMEOUT", "NORMAL_CLOSURE_STATUS", "PAGE_SIZE", "PREFETCH_DISTANCE", "SOCKET_TIMEOUT", "TOKEN_REFRESH_THRESHOLD", "TOPIC_GENERAL", "TOPIC_NEW_MATCHES", "TOPIC_NEW_MESSAGES", "WS_BASE_URL", "app_release"})
public final class Constants {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL = "https://wayoukiss.com/en/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String WS_BASE_URL = "wss://wayoukiss.com/ws/";
    public static final int NORMAL_CLOSURE_STATUS = 1000;
    public static final long SOCKET_TIMEOUT = 5000L;
    public static final long NETWORK_TIMEOUT = 30L;
    public static final int MAX_RETRIES = 3;
    public static final long CACHE_SIZE = 10485760L;
    public static final int CACHE_MAX_AGE = 604800;
    public static final int PAGE_SIZE = 20;
    public static final int PREFETCH_DISTANCE = 5;
    public static final int MAX_IMAGE_SIZE = 1048576;
    public static final int IMAGE_QUALITY = 80;
    public static final int MAX_IMAGES_PER_PROFILE = 6;
    public static final int TOKEN_REFRESH_THRESHOLD = 300000;
    public static final int BIOMETRIC_TIMEOUT = 30000;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TOPIC_NEW_MATCHES = "new_matches";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TOPIC_NEW_MESSAGES = "new_messages";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TOPIC_GENERAL = "general";
    @org.jetbrains.annotations.NotNull
    public static final com.wayoukiss.android.core.utils.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
}