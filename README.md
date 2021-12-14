# Imagely
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
#### Home/Details/Search Screens
<img src="/images/home.png" width="260">&emsp;
<img src="/images/details.png" width="260">
<img src="/images/search.png" width="260">

### Architecture
The app is build with MVVM architecture to allow separation of concerns one benefit being
allowing our data to not be destroyed over configuration changes

### Caching Strategy
*MVVM architecture allowed the use of the Repository Pattern to act as mediator between th remote and local cache data
*The Local cache is where the UI reads and observes data from. And using NetworkBoundResource its possible to set conditions where data is
```
1.Data is saved to the local database
2.Update old data with new data from Pixabay API
3.When to make a request to the Pixabay API
```
<img src="/images/mvvm_architecture.png" width="260">

### Libraries
* Retrofit - A Type-safe HTTP client for android and java which simplifies consuming RESTful APIs.
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
