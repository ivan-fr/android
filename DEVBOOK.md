# Android Development Book - WayouKiss

This devbook contains detailed development steps for implementing the WayouKiss Android application, following TDD principles and integrating with the Django API.

## Application Details
- **Name**: WayouKiss
- **Package**: `com.wayoukiss.android`
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)
- **Version Name**: 1.0.0
- **Version Code**: 1

### SDK Version Justification
- **Min SDK 26 (Android 8.0)**:
  - Covers 94.5% of active Android devices
  - Better security features (Network Security Config)
  - Improved battery life with background execution limits
  - Support for adaptive icons
  - Java 8 language features support
  - Enhanced notification channels
  - Picture-in-Picture support
  - Better WebView security

## Table of Contents
1. [Project Setup](#1-project-setup)
2. [Authentication Module](#2-authentication-module)
3. [Profile Module](#3-profile-module)
4. [Matching Module](#4-matching-module)
5. [Chat Module](#5-chat-module)
6. [Notifications Module](#6-notifications-module)

## 1. Project Setup

### 1.1 Initial Project Configuration
- [x] Create new Android project:
  ```
  Name: WayouKiss
  Package: com.wayoukiss.android
  Language: Kotlin
  Min SDK: 26 (Android 8.0)
  ```
- [x] Configure build.gradle with dependencies from CDC
- [x] Set up project structure following Clean Architecture
  ```
  com.wayoukiss.android
  ├── core
  │   ├── di
  │   ├── network
  │   ├── utils
  │   └── security
  ├── data
  │   ├── api
  │   ├── local
  │   └── repositories
  ├── domain
  │   ├── models
  │   ├── usecases
  │   └── repositories
  └── presentation
      ├── auth
      ├── chat
      ├── matching
      ├── profile
      └── notifications
  ```
- [x] Set up Git repository with .gitignore
- [x] Configure CI/CD pipeline
  - Setup GitHub Actions workflows:
    - android.yml: Main CI/CD pipeline
      - Build and test on every push
      - Release builds for main branch
      - Firebase App Distribution integration
    - pr_checks.yml: Pull Request checks
      - Code quality (ktlint, detekt)
      - Unit tests with coverage reports
      - Dependency updates check
  - Configure build steps:
    - Code compilation
    - Unit tests with JaCoCo coverage
    - Android tests
    - Code quality checks
    - APK signing for release
  - Define deployment stages:
    - Debug builds for each PR
    - Release builds for main branch
    - Automated versioning
    - Firebase App Distribution for testers
  - Security:
    - Encrypted signing keys
    - Secure environment variables
    - Firebase credentials management
- [x] Set up code quality tools (ktlint, detekt)
  - Configured ktlint:
    - Android style rules enabled
    - Custom reporters (PLAIN, CHECKSTYLE)
    - Excludes generated files
  - Configured detekt:
    - Custom rule set in detekt.yml
    - Baseline for existing issues
    - Complexity thresholds defined
    - Style and formatting rules

### 1.2 Core Module Setup
- [x] Create NetworkModule with Retrofit configuration
  - Implemented with OkHttp client and interceptors
  - Added logging for debug builds
  - Configured timeouts and error handling
- [x] Implement BaseResponse and ErrorResponse models
  - Created sealed classes for type-safe responses
  - Added NetworkResult wrapper for loading states
- [x] Set up DI with Hilt
  - NetworkModule for API configuration
  - SecurityModule for biometric and encryption
- [x] Create common utilities
  - Extensions.kt for Flow and UI helpers
  - Constants.kt for app-wide configuration
- [x] Implement base classes
  - BaseViewModel with MVI pattern
  - Coroutines Flow integration
  - Effect handling for one-time events

### 1.3 Data Layer Setup
- [x] Create Room Database configuration
  - Set up WayouKissDatabase with entities
  - Configured database version and migrations
  - Added schema export for version control
- [x] Implement base DAO interfaces
  - Created BaseDao for common operations
  - Implemented specialized DAOs (Profile, Match, Chat)
  - Added Flow support for reactive queries
- [x] Create type converters
  - DateConverter for timestamp handling
  - UUIDConverter for unique identifiers
  - List converters for arrays
- [x] Set up database entities
  - ProfileEntity with user information
  - MatchEntity for user connections
  - ChatRoomEntity and ChatMessageEntity for messaging
- [x] Implement database module for DI
  - Singleton database instance
  - DAO providers
  - Room configuration

### 1.4 Repository Layer Setup (Next)
- [ ] Create repository interfaces in domain layer
- [ ] Implement repository classes
- [ ] Set up caching strategies
- [ ] Add repository tests
- [ ] Configure DI for repositories

## 2. Authentication Module

### 2.1 Domain Layer (TDD First)
- [ ] Create AuthRepository interface
- [ ] Define AuthUseCases:
  ```kotlin
  - SignInWithGoogleUseCase
  - SignOutUseCase
  - DeleteAccountUseCase
  - RefreshTokenUseCase
  ```
- [ ] Write tests for each use case
  ```kotlin
  @Test
  fun `when sign in with valid Google token then return success`()
  @Test
  fun `when sign in with invalid Google token then return error`()
  ```

### 2.2 Data Layer
- [ ] Implement AuthApi interface with endpoints:
  ```kotlin
  // Matching Django endpoints:
  // POST /accounts/api/login/ -> TokenObtainPairView
  // POST /accounts/api/refresh/ -> TokenRefreshView
  // POST /accounts/api/logout/ -> logout_api
  // POST /accounts/api/delete/ -> delete_account_api
  ```
- [ ] Create AuthRepositoryImpl
- [ ] Write repository tests using MockWebServer

### 2.3 Presentation Layer
- [ ] Create AuthViewModel with states:
  ```kotlin
  sealed class AuthState {
      object Loading : AuthState()
      data class Success(val user: User) : AuthState()
      data class Error(val message: String) : AuthState()
  }
  ```
- [ ] Implement SignInFragment with Google Sign-In button
- [ ] Write UI tests for authentication flow

## 3. Profile Module

### 3.1 Domain Layer (TDD First)
- [ ] Create ProfileRepository interface
- [ ] Define ProfileUseCases:
  ```kotlin
  - GetProfileUseCase
  - UpdateProfileUseCase
  - UploadPhotoUseCase
  - DeletePhotoUseCase
  ```
- [ ] Write tests for each use case

### 3.2 Data Layer
- [ ] Implement ProfileApi interface
- [ ] Create ProfileRepositoryImpl
- [ ] Set up Room database for profile caching
- [ ] Write repository tests

### 3.3 Presentation Layer
- [ ] Create ProfileViewModel
- [ ] Implement ProfileFragment
- [ ] Create EditProfileFragment
- [ ] Write UI tests for profile management

## 4. Matching Module

### 4.1 Domain Layer (TDD First)
- [ ] Create MatchingRepository interface
- [ ] Define MatchingUseCases:
  ```kotlin
  - GetPotentialMatchesUseCase
  - LikeProfileUseCase
  - PassProfileUseCase
  - GetMatchesUseCase
  ```
- [ ] Write tests for each use case

### 4.2 Data Layer
- [ ] Implement MatchingApi interface
- [ ] Create MatchingRepositoryImpl
- [ ] Set up Room database for matches
- [ ] Write repository tests

### 4.3 Presentation Layer
- [ ] Create MatchingViewModel
- [ ] Implement SwipeFragment
- [ ] Create MatchesListFragment
- [ ] Write UI tests for matching functionality

## 5. Chat Module

### 5.1 Domain Layer (TDD First)
- [ ] Create ChatRepository interface
- [ ] Define ChatUseCases:
  ```kotlin
  - GetChatRoomsUseCase
  - GetMessagesUseCase
  - SendMessageUseCase
  - ConnectWebSocketUseCase
  ```
- [ ] Write tests for each use case

### 5.2 Data Layer
- [ ] Implement ChatApi interface:
  ```kotlin
  // Matching Django endpoints:
  // GET /interactions/api/chat/<room_id>/ -> chat_room_api
  // GET /interactions/api/chats/ -> chat_list_api
  // POST /interactions/api/chat/create/<user_id>/ -> create_chat_room_api
  ```
- [ ] Create ChatRepositoryImpl
- [ ] Set up WebSocket connection handler
- [ ] Set up Room database for messages
- [ ] Write repository tests

### 5.3 Presentation Layer
- [ ] Create ChatViewModel
- [ ] Implement ChatListFragment
- [ ] Create ChatRoomFragment
- [ ] Write UI tests for chat functionality

## 6. Notifications Module

### 6.1 Domain Layer (TDD First)
- [ ] Create NotificationRepository interface
- [ ] Define NotificationUseCases:
  ```kotlin
  - RegisterDeviceUseCase
  - HandlePushNotificationUseCase
  - UpdateNotificationSettingsUseCase
  ```
- [ ] Write tests for each use case

### 6.2 Data Layer
- [ ] Implement NotificationApi interface
- [ ] Create NotificationRepositoryImpl
- [ ] Set up Firebase Cloud Messaging
- [ ] Write repository tests

### 6.3 Presentation Layer
- [ ] Create NotificationViewModel
- [ ] Implement NotificationSettingsFragment
- [ ] Create NotificationListFragment
- [ ] Write UI tests for notification handling

## Progress Tracking

### Current Sprint Status
- Started: 2025-01-28
- Target Completion: 2025-02-28
- Current Focus: Project Setup

### Version Control Strategy
- **Main Branches**:
  - `main`: Production-ready code
  - `develop`: Development integration
- **Feature Branches**:
  - Format: `feature/[module]-[description]`
  - Example: `feature/auth-google-signin`
- **Release Branches**:
  - Format: `release/[version]`
  - Example: `release/1.0.0`
- **Hotfix Branches**:
  - Format: `hotfix/[issue]-[description]`
  - Example: `hotfix/auth-token-refresh`

### Build Variants
- **Debug**:
  - Logging enabled
  - Development API endpoint
  - Debug signing config
- **Release**:
  - ProGuard enabled
  - Production API endpoint
  - Release signing config
- **Staging**:
  - Logging enabled
  - Staging API endpoint
  - Debug signing config

### UI/UX Guidelines
- **Color Scheme**:
  ```xml
  <color name="primary">#FF6200EE</color>
  <color name="secondary">#FF03DAC5</color>
  <color name="background">#FFFFFFFF</color>
  <color name="surface">#FFFFFFFF</color>
  <color name="error">#FFB00020</color>
  ```
- **Typography**:
  - Display: Roboto Medium
  - Headline: Roboto Regular
  - Body: Roboto Light
- **Components**:
  - Use Material3 components
  - Custom theme overlay for dating app style
  - Consistent corner radius: 16dp
  - Standard elevation: 2dp, 4dp, 8dp

### Security Guidelines
1. **Data Protection**:
   - Encrypt sensitive data using EncryptedSharedPreferences
   - Use BiometricPrompt for sensitive actions
   - Clear data on logout
   
2. **Network Security**:
   - Certificate pinning
   - SSL/TLS enforcement
   - Token refresh mechanism
   
3. **Input Validation**:
   - Client-side validation
   - Content validation before API calls
   - File size and type validation

### Performance Requirements
- **Launch Time**: < 2 seconds cold start
- **Frame Rate**: 60fps for animations
- **API Response**: < 3 seconds
- **Image Loading**: < 1 second with caching
- **Memory Usage**: < 200MB
- **Battery Impact**: < 5% per hour active use

## Completed Features
- [ ] Authentication
- [ ] Profile Management
- [ ] Matching System
- [ ] Chat Functionality
- [ ] Push Notifications

### Testing Coverage
- [ ] Domain Layer: [X]% (Target: 95%)
- [ ] Data Layer: [X]% (Target: 90%)
- [ ] Presentation Layer: [X]% (Target: 85%)
- [ ] Overall Coverage: [X]% (Target: 90%)

## Notes

### API Endpoints Summary

Base URL: `https://wayoukiss.com/en/`

#### Authentication Endpoints (`accounts/api/`)
| Endpoint | Method | File | Description |
|----------|--------|------|-------------|
| `token/refresh/` | POST | `accounts/api.py:CustomTokenRefreshView` | Refresh JWT token |
| `logout/` | POST | `accounts/api.py:logout_api` | Logout user |
| `delete-account/` | POST | `accounts/api.py:delete_account_api` | Delete user account |
| `apple/auth/` | POST | `accounts/apple_auth.py:apple_auth` | Apple Sign-In |
| `google/auth/` | POST | `accounts/google_auth.py:google_auth` | Google Sign-In |
| `ping/` | GET | `accounts/api.py:ping` | Health check |

#### Chat & Interactions (`interactions/api/`)
| Endpoint | Method | File | Description |
|----------|--------|------|-------------|
| `chat/<room_id>/` | GET | `interactions/api.py:chat_room_api` | Get chat room details |
| `chats/` | GET | `interactions/api.py:chat_list_api` | List all chat rooms |
| `chat/create/<user_id>/` | POST | `interactions/api.py:create_chat_room_api` | Create new chat room |

#### WebSocket Endpoints (`ws/`)
Base WebSocket URL: `wss://wayoukiss.com/ws/`
| Endpoint | File | Description |
|----------|------|-------------|
| `chat/<room_id>/` | `interactions/consumers.py` | Real-time chat messages |
| `online/` | `interactions/consumers.py` | Online status updates |
| `unread-messages/` | `interactions/consumers.py` | Unread messages notifications |

#### Profiles (`profiles/api/`)
| Endpoint | Method | Description |
|----------|--------|-------------|
| `profile/` | GET/PUT | Get/Update user profile |
| `photos/` | POST | Upload profile photo |
| `photos/<id>/` | DELETE | Delete profile photo |

#### Matching (`matching/api/`)
| Endpoint | Method | Description |
|----------|--------|-------------|
| `matches/` | GET | Get user matches |
| `potential/` | GET | Get potential matches |
| `like/<id>/` | POST | Like a profile |
| `pass/<id>/` | POST | Pass a profile |

#### Notifications (`api/notifications/`)
| Endpoint | Method | Description |
|----------|--------|-------------|
| `register-device/` | POST | Register device for push notifications |
| `settings/` | GET/PUT | Get/Update notification preferences |

### API Integration Guidelines
1. All authenticated endpoints require JWT token in header:
   ```kotlin
   Authorization: Bearer <access_token>
   ```
2. Error handling should follow the standard response format:
   ```json
   {
     "error": "Error type",
     "detail": "Error description",
     "code": "error_code"
   }
   ```
3. WebSocket connections require token authentication via query parameter:
   ```
   ws://wayoukiss.com/ws/chat/<room_id>/?token=<access_token>
   ```

### Development Guidelines
- This devbook will be updated as development progresses
- Each task should follow TDD principles: Red -> Green -> Refactor
- API integration should be tested with both success and failure cases
- UI should be implemented according to Material3 guidelines
