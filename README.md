# Imagely
This app consumes The Pixabay Api to fetch and display a list of images, The app uses MVVM design pattern to allow separation of the app components like fragments & activities from the data logic the reasons I leaned to this app architecture are:
* make the data survive device configuration changes
* allow testability(unit test) of the data layer
* improve codebase robustability by catching all edge error cases
* Also it's easier to maintain and scale the app over time
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
The app is build with MVVM Design Pattern to allow separation of concerns one benefit being
allowing our data to not be destroyed over configuration changes

### Caching Strategy
* MVVM architecture allowed the use of the Repository Pattern to act as mediator between th remote and local cache data
* The Local cache is where the UI reads and observes data from. And using NetworkBoundResource its possible to set conditions where data is
```
1.Data is saved to the local database
2.Update old data with new data from Pixabay API
3.When to make a request to the Pixabay API
```
<img src="/images/mvvm_architecture.png">

https://user-images.githubusercontent.com/72180010/145916765-dab037e5-6cb1-4c7c-8674-4dfb62e380d3.mp4

### Libraries
* Navigation Components - To implement the Single Activity approach since fragments are lightweight than activities and allows easy passing of data between arguments in a type safe way
* Retrofit - A Type-safe HTTP client for Android which simplifies consuming RESTFul APIs.
* Gson - Converts JSON to Java/Kotlin objects.
* OkHttp-logging-interceptor - Makes it easy to log OkHttp network responses and requests
* Coil - Image loader library for android
* Dagger Hilt - Used for Dependency Injection
* Room - Persistence library making it easier to work with SQLite database
* View Binding - Jetpack library allowing type safe binding of views
* Livedata - Notifies Observer objects in the UI when underlying data changes.

## Author Info
* Twitter - [@BreensR](https://twitter.com/BreensR)
* Linkedin - [LinkedIn: Breens Robert](https://www.linkedin.com/in/breens-mbaka/)

## License
[MIT](https://choosealicense.com/licenses/mit/)
