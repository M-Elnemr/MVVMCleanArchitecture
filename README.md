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

usecase (Powered up with coroutines)

Room database


Each view has it's own module to keep everything seperate and clean.

I used usecase for every request to keep everyrequest clear and seperated.

View (fragment or activity) - ViewModel - Usecase (kotin coroutines) - Repository -> (request data form local database or server).

Everything is optimized and every class has a generic parent.

![1](https://user-images.githubusercontent.com/50822992/129482028-8f0ef5a2-bf1d-4db2-ac93-4fb658c9015e.jpg)

![2](https://user-images.githubusercontent.com/50822992/129482067-f6ec0881-020f-40be-a2dd-af68d7c22c09.jpg)

