# RapidScore
This app consumes The Pixabay Api to fetch and display a list of images, The app uses MVVM architecture.
<br>

Minimum API level supported: 21
<br>
Build System: [Gradle](https://gradle.org/)

### Prerequisite
To run the project you should have the following tools
* Android Studio 4.0 or above
* Internet connection

### Screenshots
#### Home/Details Screens
<img src="/images/home.png" width="260">&emsp;
<img src="/images/Details.png" width="260">

#### Search Screen
<img src="/images/search.png" width="260">


### Architecture
The app is build with MVVM clean architecture to allow separation of concerns one benefit being
allowing our data to not be destroyed over configuration changes.

### Libraries
* Retrofit - A Type-safe HTTP client for android and java which simplfies consuming RESTful APIs.
* Gson - Converts JSON to Java/Kotlin objects.
* OkHttp-logging-interceptor - Makes it easy to log OkHttp network traffic
* Coil - Image loader library for android
* Dagger Hilt - Used for Dependency Injection
* Room - Persistence library making it easier to work with SQLite database
* View Binding - Jetpack library allowing type safe binding of views
* ViewModel - Designed to store and manage UI data in a lifecycle aware fashion.

### License
[MIT](https://choosealicense.com/licenses/mit/)

### Author Info
* Twitter - [@BreensR](https://twitter.com/BreensR)
* Linkedin - [LinkedIn: Breens Mbaka](https://www.linkedin.com/in/breens-mbaka-b447781b9/)
