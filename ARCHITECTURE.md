# High-Level Architectural Outline

This document outlines the high-level architecture for the Tool Rental Android application. The architecture is based on the MVVM (Model-View-ViewModel) pattern with Clean Architecture principles.

## Layers

The application is divided into the following layers:

*   **UI Layer:** This layer is responsible for displaying the user interface and handling user input. It consists of Activities, Fragments, and Jetpack Compose components.
*   **ViewModel Layer:** This layer is responsible for exposing data to the UI and handling user interactions. It communicates with the Domain layer to retrieve and update data.
*   **Domain Layer:** This layer contains the business logic of the application. It consists of Use Cases that represent specific user actions.
*   **Data Layer:** This layer is responsible for providing data to the Domain layer. It consists of Repositories that abstract away the data sources.
*   **Data Sources:** This layer consists of the remote and local data sources. The remote data source is a REST API, and the local data source is a Room database.

## Communication Between Layers

The communication between the layers is as follows:

*   The UI layer communicates with the ViewModel layer to get data and notify it of user interactions.
*   The ViewModel layer communicates with the Domain layer to execute business logic.
*   The Domain layer communicates with the Data layer to get and store data.
*   The Data layer communicates with the Data Sources to fetch and store data.

## Diagram

```
+-----------------+      +-----------------+      +-----------------+      +-----------------+      +-----------------+
|      UI         |      |    ViewModel    |      |      Domain     |      |      Data       |      |   Data Sources  |
| (Activities,    |      |   (ViewModel)   |      |    (Use Cases)  |      |  (Repositories) |      | (Remote/Local)  |
|   Fragments,    |      |                 |      |                 |      |                 |      |                 |
|    Compose)     |      |                 |      |                 |      |                 |      |                 |
+-----------------+      +-----------------+      +-----------------+      +-----------------+      +-----------------+
        |                      ^                      ^                      ^                      ^
        |                      |                      |                      |                      |
        +--------------------->+--------------------->+--------------------->+--------------------->+
```
