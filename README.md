# CreditScore

## UserPhotos app loads and displays user photos

    * The app is written in Kotlin
    * The app consist of single screen where user photos are loaded and displayed 
    * If error occurred when loading the user report from REST API, error message is displayed

## **App architecture**

    * The app has 3 modules
        ** app module. In this module we have the UI and domain logic.
            *** User photos UI and domain logic is in a separate package to make it easier to move into a 
                separate feature module if and when it is required
        ** photosapi module - the network layer of the app 
        ** core module - module for common functionality and interfaces

## **Technologies used**

    * Android architecture componens
    * Hilt as DI framework
    * RxJava for asynchronous operations
    * Retrofit to connect to Rest API. Retrofit cache is enabled to cache API responses
    * Moshi for parsing JSON and deserializing it into Kotlin objects and serializing objects into JSON
    * Picasso for image loading

## **TODO**
    * Add data layer to cache API response and handle offline mode
