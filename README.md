# Beer_Pairing_App
This is an Android application for CS4540

# Dependencies needed for the project
The following dependencies go in your **build.gradle (Module:app)** file:  

`implementation 'com.google.code.gson:gson:2.8.6'`  
`implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1"`  
`implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.1.1"`  
`implementation 'com.squareup.retrofit2:retrofit:2.7.0'`  
`implementation "com.squareup.retrofit2:converter-gson:2.7.0"`  
`implementation 'androidx.lifecycle:lifecycle-extensions:2.1.0'`  

# Links for Libraries used
**Retrofit** is used to fetch data from APIs:  
- [Retrofit](https://square.github.io/retrofit/)

**Gson** is used to parse JSON data:  
- [Gson](https://guides.codepath.com/android/leveraging-the-gson-library)  

# Link for APIs used  
**Punk API**  
- [Punk API](https://punkapi.com/documentation/v2)

# Other settings enabled in build.gradle (Module.app)
Add the following lines to `android{...  }` to enable **data binding**  
```
dataBinding {  
  enabled = true  
}  
```
