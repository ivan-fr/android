# Cahier des Charges - Application Mobile de Rencontres

## 1. Introduction

### 1.1 Objectif
Développement d'une application mobile Android native en Kotlin qui se connecte à une API Django existante pour créer une plateforme de rencontres complète et sécurisée.

### 1.2 Technologies
- Langage : Kotlin 1.9.22
- SDK Android : API 34 (Android 14)
- Architecture : Clean Architecture + MVVM
- Jetpack :
  - Compose 1.5.4 : UI déclarative moderne
  - Navigation Compose 2.7.6 : Navigation entre les écrans
  - Room 2.6.1 : Persistence des données
  - Lifecycle 2.7.0 : Gestion du cycle de vie
  - ViewModel 2.7.0 : État de l'UI
  - Hilt 2.50 : Injection de dépendances
- Réseau :
  - Retrofit 2.9.0 : Client HTTP
  - OkHttp 4.12.0 : WebSocket et intercepteurs
  - Kotlinx.Serialization 1.6.2 : Sérialisation JSON
- Coroutines 1.7.3 : Programmation asynchrone
- Flow 1.7.3 : Flux de données réactifs
- Tests :
  - JUnit 5 : Tests unitaires
  - Mockk 1.13.8 : Mocking pour Kotlin
  - Espresso 3.5.1 : Tests UI
  - Turbine 1.0.0 : Test des Flows
- UI/UX :
  - Material3 : Design system
  - Coil 2.5.0 : Chargement d'images
  - Accompanist 0.32.0 : Extensions Compose
- Firebase :
  - Cloud Messaging 23.4.0 : Notifications push
  - Analytics 21.5.0 : Analyse d'utilisation
- Sécurité :
  - Security Crypto 1.1.0-alpha06 : Cryptographie
  - Biometric 1.2.0-alpha05 : Authentification biométrique

## 2. Architecture Technique

### 2.1 Modules
- `app` : Module principal de l'application
- `core` : Composants communs et utilitaires
- `data` : Sources de données et repositories
- `domain` : Logique métier et use cases
- `presentation` : UI et ViewModels

### 2.2 Packages Principaux
```
com.projet
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

### 2.3 Gestion des Données

#### Cache Local
- Room Database :
  - `UserEntity` : Profils utilisateurs
  - `MatchEntity` : Matchs entre utilisateurs
  - `MessageEntity` : Messages de chat
  - Indices et clés étrangères pour optimiser les performances
  - Converters pour les types complexes (Date, UUID)

#### API REST
- Base URL : `https://wayoukiss.com/en/`
- Authentification :
  - JWT Token dans le header `Authorization`
  - Refresh token pour renouveler l'accès
  - Intercepteur OkHttp pour la gestion automatique
- Endpoints :
  - `/accounts/api/*` : Authentification et gestion de compte
  - `/interactions/api/*` : Chat et interactions
  - `/matching/api/*` : Système de matching
  - `/profiles/api/*` : Gestion des profils
  - `/api/notifications/*` : Notifications push

#### WebSocket
- Base URL : `wss://wayoukiss.com/ws/`
- Endpoints :
  - `/ws/chat/<room_id>/` : Messages en temps réel
  - `/ws/online/` : Statut en ligne
  - `/ws/unread-messages/` : Notifications de messages
- Gestion :
  - Reconnexion automatique en cas de déconnexion
  - Cache local des messages pour le mode hors ligne
  - État de connexion observable via Flow

### 2.4 Sécurité

#### Authentification
- Google Sign-In :
  - OAuth 2.0
  - Token refresh automatique
  - Déconnexion sécurisée
- Stockage sécurisé :
  - EncryptedSharedPreferences pour les tokens
  - Room pour les données utilisateur
  - Chiffrement des messages sensibles

#### Protection des Données
- SSL/TLS pour toutes les communications
- Validation des entrées utilisateur
- Sanitization des données
- Rate limiting sur les requêtes API
- Timeout des sessions

## 3. Fonctionnalités Détaillées

### 3.1 Authentification
- Google Sign-In
- Gestion des tokens JWT
- Refresh token automatique
- Déconnexion sécurisée
- Suppression de compte

### 3.2 Profil Utilisateur
- Configuration initiale du profil
- Gestion des photos (upload, ordre)
- Édition des informations
- Préférences de matching
- Blocage et signalement

### 3.3 Matching
- Découverte de profils
- Système de like/pass
- Liste des matchs
- Gestion des préférences
- Historique des likes

### 3.4 Chat
- Conversations en temps réel
- Liste des conversations
- Indicateurs de lecture
- Statut en ligne
- Notifications push

### 3.5 Notifications
- Enregistrement des appareils
- Gestion des notifications push
- Centre de notifications
- Marquage comme lu

## 4. Tests

### 4.1 Tests Unitaires
- ViewModels
- Use Cases
- Repositories
- Mappers
- Utils

### 4.2 Tests d'Intégration
- API calls
- Database operations
- WebSocket connections

### 4.3 Tests UI
- Navigation flows
- User interactions
- Error states
- Loading states

### 4.4 Test-Driven Development (TDD)

#### 4.4.1 TDD Cycle
- **Red**: Write failing test first
  - Create test for new feature/functionality
  - Verify test fails (red phase)
  - Tests define expected behavior
- **Green**: Write minimal code to pass
  - Implement minimal code to make test pass
  - Focus on functionality, not optimization
  - Verify all tests pass (green phase)
- **Refactor**: Improve code quality
  - Clean up code while maintaining test coverage
  - Apply SOLID principles and design patterns
  - Ensure all tests still pass

#### 4.4.2 TDD Implementation Strategy
- **Unit Tests First**
  - Start with domain layer (Use Cases, Models)
  - Test business logic in isolation
  - Use Mockk for dependencies
  - Example:
    ```kotlin
    @Test
    fun `when like profile then match status updated`() {
        // Arrange
        val profileId = "123"
        // Act
        viewModel.likeProfile(profileId)
        // Assert
        verify { matchRepository.updateMatchStatus(profileId, MatchStatus.LIKED) }
    }
    ```

- **Integration Tests Second**
  - Test repositories with actual Room database
  - Verify API interactions with MockWebServer
  - Test component interactions
  - Example:
    ```kotlin
    @Test
    fun `when fetching matches then local cache updated`() {
        // Arrange
        mockWebServer.enqueue(MockResponse().setBody(matchesJson))
        // Act
        runBlocking { repository.fetchMatches() }
        // Assert
        val cachedMatches = database.matchDao().getAll()
        assertThat(cachedMatches).hasSize(5)
    }
    ```

- **UI Tests Last**
  - Test user flows with Espresso
  - Verify UI state changes
  - Test error handling and loading states
  - Example:
    ```kotlin
    @Test
    fun `when profile liked then match animation shown`() {
        // Arrange
        launchMatchingScreen()
        // Act
        onView(withId(R.id.likeButton)).perform(click())
        // Assert
        onView(withId(R.id.matchAnimation)).check(matches(isDisplayed()))
    }
    ```

#### 4.4.3 TDD Benefits
- Early bug detection
- Better code design and modularity
- Living documentation through tests
- Confidence in refactoring
- Reduced debugging time
- Clear acceptance criteria

#### 4.4.4 Code Coverage Goals
- Domain Layer: 95%+ coverage
- Data Layer: 90%+ coverage
- Presentation Layer: 85%+ coverage
- Overall Project: 90%+ coverage

#### 4.4.5 TDD Workflow Integration
- Pre-commit hooks for test execution
- CI/CD pipeline integration
- Code review checklist includes test review
- Regular test maintenance and updates
- Performance testing benchmarks

## 5. Sécurité

### 5.1 Authentification
- Stockage sécurisé des tokens
- Refresh automatique
- Validation des tokens

### 5.2 Communication
- HTTPS pour toutes les requêtes
- WSS pour les WebSockets
- Certificate pinning
- Encryption des données sensibles

### 5.3 Stockage Local
- Encryption des données sensibles
- Nettoyage des données à la déconnexion
- Protection contre le root/jailbreak

## 6. Performance

### 6.1 Optimisations
- Mise en cache des images
- Pagination des listes
- Prefetching des données
- Compression des images
- Gestion de la bande passante

### 6.2 Offline Mode
- Stockage local des conversations
- Queue des actions offline
- Synchronisation automatique

## 7. Monitoring et Analytics

### 7.1 Crashlytics
- Rapport de crash
- ANR monitoring
- Stack traces

### 7.2 Analytics
- Comportement utilisateur
- Performance
- Engagement
- Conversion

## 8. Plan de Développement

### 8.1 Phase 1 - Core & Auth
- Setup du projet
- Implémentation de l'authentification
- Tests de base

### 8.2 Phase 2 - Profil & Matching
- Gestion des profils
- Système de matching
- Tests associés

### 8.3 Phase 3 - Chat & Notifications
- Système de chat
- Notifications push
- Tests de performance

### 8.4 Phase 4 - Polish & Release
- UI/UX final
- Tests de régression
- Préparation store

## 9. Livrables

### 9.1 Documentation
- Documentation technique
- Guide d'API
- Guide de déploiement
- Documentation utilisateur

### 9.2 Code
- Repository Git
- Tests automatisés
- Documentation inline
- Release notes

### 9.3 Assets
- Design system
- Resources graphiques
- Configurations

### 1.1 Routes API

Base URLs :
- HTTP/HTTPS API : `https://wayoukiss.com/en`
- WebSocket API : `wss://wayoukiss.com`

#### Accounts API (`accounts/urls.py`, `accounts/api.py`, `accounts/google_auth.py`)
- `/accounts/api/google/auth/` (POST) : Authentification via Google
- `/accounts/api/token/refresh/` (POST) : Rafraîchissement du token JWT
- `/accounts/api/logout/` (POST) : Déconnexion et blacklist du token
- `/accounts/api/delete-account/` (POST) : Suppression du compte
- `/accounts/api/ping/` (GET) : Vérification de la connexion

#### Interactions API (`interactions/urls.py`, `interactions/api.py`)
- `/interactions/api/chat/create/<uuid:user_id>/` (POST) : Création d'une nouvelle salle de chat
- `/interactions/api/chat/<uuid:room_id>/` (GET) : Accès à une salle de chat (nécessite d'abord la création via `/interactions/api/chat/create/<uuid:user_id>/`)
- `/interactions/api/chats/` (GET) : Liste des salles de chat

#### Matching API (`matching/urls.py`, `matching/api.py`)
- `/matching/api/matches/` (GET) : Liste des matchs actuels
- `/matching/api/discover/` (GET) : Découverte de nouveaux profils
- `/matching/api/like/<uuid:user_id>/` (POST) : Liker un profil
- `/matching/api/pass/<uuid:user_id>/` (POST) : Passer un profil
- `/matching/api/preferences/` (GET/POST) : Gestion des préférences de matching
- `/matching/api/liked-profiles/` (GET) : Liste des profils likés et qui nous ont likés

#### Notifications API (`notifications/urls.py`, `notifications/api.py`)
- `/api/notifications/register-device/` (POST) : Enregistrement d'un appareil pour les notifications push
- `/api/notifications/deregister-device/` (POST) : Désinscription d'un appareil
- `/api/notifications/list-notifications/` (GET) : Liste des notifications
- `/api/notifications/<uuid:id>/mark-as-read/` (POST) : Marquer une notification comme lue

#### Profiles API (`profiles/urls.py`, `profiles/api.py`)
- `/profiles/api/profile/me/` (GET) : Obtenir son profil
- `/profiles/api/setup/` (GET/POST) : Configuration initiale du profil
- `/profiles/api/edit/` (POST) : Modification du profil
- `/profiles/api/photos/` (POST) : Gestion des photos
- `/profiles/api/photos/update-order/` (POST) : Mettre à jour l'ordre des photos
- `/profiles/api/preferences/` (GET/POST) : Gestion des préférences
- `/profiles/api/view/<uuid:user_id>/` (GET) : Voir le profil d'un autre utilisateur
- `/profiles/api/block/<uuid:user_id>/` (POST) : Bloquer un utilisateur
- `/profiles/api/report/<uuid:user_id>/` (POST) : Signaler un utilisateur

### 1.2 WebSocket Endpoints (`bloodydimary/asgi.py`, `interactions/consumers.py`)

L'application utilise les WebSockets suivants :
- `/ws/chat/<room_name>/` : Communication en temps réel pour le chat
- `/ws/online/` : Statut en ligne des utilisateurs
- `/ws/unread-messages/` : Notifications des messages non lus
