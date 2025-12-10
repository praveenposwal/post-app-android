# Android App

A modern Android application built with Kotlin, following Clean Architecture and MVVM principles.

## Overview

This application demonstrates a robust and scalable architecture for Android development. It features:
-   **User Authentication**: Login screen with session persistence.
-   **Post Feed**: Displays a list of posts fetched from a local server.
-   **Search**: Real-time search with debounce and text highlighting.
-   **Post Details**: Detailed view of posts with comments.
-   **Favorites**: Ability to mark posts as favorites and view them offline.
-   **Offline Support**: Caches data locally using Room database.
-   **Settings**: User settings and logout functionality.

## Tech Stack & Libraries

This project utilizes the following libraries and frameworks:

### Architecture & Core
-   **[Kotlin](https://kotlinlang.org/)**: First-class programming language for Android.
-   **[MVVM (Model-View-ViewModel)](https://developer.android.com/topic/libraries/architecture/viewmodel)**: Architectural pattern for separation of concerns.
-   **[Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)**: Separation of code into Domain, Data, and UI layers.
-   **[Hilt](https://dagger.dev/hilt/)**: Dependency Injection library for Android.
-   **[Coroutines & Flow](https://kotlinlang.org/docs/coroutines-overview.html)**: Asynchronous programming and data streams.

### Android Jetpack
-   **[Navigation Component](https://developer.android.com/guide/navigation)**: Handling in-app navigation and deep linking.
-   **[Safe Args](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args)**: Type-safe navigation arguments.
-   **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)**: Store and manage UI-related data in a lifecycle-conscious way.
-   **[Room](https://developer.android.com/training/data-storage/room)**: Persistence library provides an abstraction layer over SQLite.
-   **[DataStore](https://developer.android.com/topic/libraries/architecture/datastore)**: Data storage solution for key-value pairs (Preferences).

### Network & Image Loading
-   **[Retrofit](https://square.github.io/retrofit/)**: Type-safe HTTP client for Android and Java.
-   **[OkHttp](https://square.github.io/okhttp/)**: HTTP client for Android.
-   **[Gson](https://github.com/google/gson)**: JSON serialization/deserialization.
-   **[Glide](https://github.com/bumptech/glide)**: Fast and efficient image loading library.

### UI
-   **[Material Design Components](https://github.com/material-components/material-components-android)**: Modular and customizable Material Design UI components.
-   **[ConstraintLayout](https://developer.android.com/training/constraint-layout)**: Flexible and efficient layout manager.

## Setup

1.  Clone the repository.
2.  Open in Android Studio.
3.  Ensure the local server is running (if applicable, e.g., `json-server`).
4.  Build and run the app.
