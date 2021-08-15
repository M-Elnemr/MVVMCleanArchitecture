# MVVMCleanArchitecture

it's a simple Showcase project that presents a modern, 2021 approach to Android application development.

# Tech-stack
Kotlin
Kotlin Coroutines
Hilt for dependency injection
data binding
-Jetpack-
Navigation Components
LiveData
Lifecycle
ViewModel
usecase
Room database

Each view has it's own module to make everything seperate and clean.
I used usecase for every request for easier test .

View(fragment or activity) - ViewModel - Usecase - Repository -> (request data form local database or server).

Everything is optimized and every class has a generic parent.
