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

# Link for API used  
**Punk API**  
- [Punk API](https://punkapi.com/documentation/v2)  
Sample Request using **food** as parameter  
`https://api.punkapi.com/v2/beers?food=spicy`

Sample JSON object from request  
`{"id":1,
"name":"Buzz","tagline":"A Real Bitter Experience.",
"first_brewed":"09/2007",
"description":"A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.",
"abv":4.5,
"food_pairing":["Spicy chicken tikka masala","Grilled chicken quesadilla","Caramel toffee cake"]}`


# Other settings enabled in build.gradle (Module.app)
Add the following lines to `android{...  }` to enable **data binding**  
```
dataBinding {  
  enabled = true  
}  
```
# Main Menu
<img width="356" alt="Screen Shot 2019-12-12 at 6 22 36 PM" src="https://user-images.githubusercontent.com/43188828/70767615-d51aa280-1d16-11ea-8ca5-2d904346b801.png">
