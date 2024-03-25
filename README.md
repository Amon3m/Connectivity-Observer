# Internet Connectivity Observer

This project demonstrates how to observe network connectivity changes in an Android application using Kotlin Coroutines and Dagger Hilt.

## Overview

The application observes changes in network connectivity status and displays corresponding messages in the UI. It utilizes the Android ConnectivityManager to register a network callback and receive notifications about network status changes.

## Features

- Observes network connectivity changes in real-time.
- Displays messages indicating the current network status (e.g., Available, Unavailable, Losing, Lost) in the UI.

## Architecture

The project follows a clean architecture pattern, with the following layers:

- **Presentation Layer**: Contains UI-related components such as activities, fragments, and view models.
- **Domain Layer**: Contains business logic and use cases.
- **Data Layer**: Contains classes for data retrieval and manipulation, including the `NetworkConnectivityObserver` for observing network connectivity changes.

## Tech Stack

- Android Jetpack components (ViewModel, StateFlow)
- Kotlin Coroutines for asynchronous programming
- Dagger Hilt for dependency injection
- AndroidX libraries for UI components and lifecycle management

## Usage

- Upon launching the app, the current network status will be displayed.
- As network connectivity changes occur, the UI will update to reflect the new status.