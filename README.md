# Wayoukiss Android App

Application de rencontre développée avec Kotlin et Jetpack Compose.

## 🛠 Technologies utilisées

- Kotlin
- Jetpack Compose
- Material 3
- Hilt (Injection de dépendances)
- Retrofit (Appels API)
- Room (Base de données locale)
- WebSocket (Chat en temps réel)
- Coroutines & Flow
- JUnit, Mockk, Turbine (Tests)

## 🏗 Architecture

L'application suit une architecture Clean Architecture avec le pattern MVVM :

- `data` : Sources de données (API, Base de données)
- `domain` : Logique métier et modèles
- `presentation` : UI avec Jetpack Compose
- `core` : Composants partagés

## 🚀 Installation

1. Cloner le repository
```bash
git clone https://github.com/VOTRE_USERNAME/wayoukiss-android.git
```

2. Ouvrir le projet dans Android Studio

3. Synchroniser le projet avec Gradle

4. Lancer l'application

## 🧪 Tests

Pour lancer les tests unitaires :
```bash
./gradlew test
```

Pour lancer les tests d'intégration :
```bash
./gradlew connectedCheck
```

## 📱 Fonctionnalités

- Authentification Google
- Profil utilisateur
- Matching
- Chat en temps réel
- Notifications

## 📝 Documentation

La documentation complète du projet se trouve dans le dossier `docs` :
- [CDC.md](CDC.md) : Cahier des charges
- [devbook.md](devbook.md) : Journal de développement
