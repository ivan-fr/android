package com.wayoukiss.android.core.utils

object Constants {
    // API Endpoints
    const val BASE_URL = "https://wayoukiss.com/en/"
    const val WS_BASE_URL = "wss://wayoukiss.com/ws/"
    
    // WebSocket
    const val NORMAL_CLOSURE_STATUS = 1000
    const val SOCKET_TIMEOUT = 5000L
    
    // Network
    const val NETWORK_TIMEOUT = 30L
    const val MAX_RETRIES = 3
    
    // Cache
    const val CACHE_SIZE = 10L * 1024 * 1024 // 10MB
    const val CACHE_MAX_AGE = 7 * 24 * 60 * 60 // 1 week
    
    // Pagination
    const val PAGE_SIZE = 20
    const val PREFETCH_DISTANCE = 5
    
    // Images
    const val MAX_IMAGE_SIZE = 1024 * 1024 // 1MB
    const val IMAGE_QUALITY = 80
    const val MAX_IMAGES_PER_PROFILE = 6
    
    // Security
    const val TOKEN_REFRESH_THRESHOLD = 5 * 60 * 1000 // 5 minutes
    const val BIOMETRIC_TIMEOUT = 30000 // 30 seconds
    
    // Firebase Topics
    const val TOPIC_NEW_MATCHES = "new_matches"
    const val TOPIC_NEW_MESSAGES = "new_messages"
    const val TOPIC_GENERAL = "general"
}
