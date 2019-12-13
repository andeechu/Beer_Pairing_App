# Beer_Pairing_App
This is an Android application created as a project for CS4540. The application suggests beers based on the following food categories:  
- Spicy
- Sweet
- Sour
- Bitter

Once the category is selected, the app will display various beers that go well with the selected category. It will list various beers and display the name of the beer, a tagline, a brief description, alcohol by volume, and foods that go well for each beer listed. 

# Team
- Andy Echeverria
- Michael Valdez
- Jesus Gonzalez

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
# Main Menu and Results Example

Main Menu                  |  Result 
:-------------------------:|:-------------------------:
<img width="356" alt="Screen Shot 2019-12-12 at 6 22 36 PM" src="https://user-images.githubusercontent.com/43188828/70767615-d51aa280-1d16-11ea-8ca5-2d904346b801.png">  |  <img width="347" alt="Screen Shot 2019-12-12 at 6 23 04 PM" src="https://user-images.githubusercontent.com/43188828/70767806-773a8a80-1d17-11ea-8744-d8117d667d22.png">)  

# Details
A major component in the app is the recyclerView that was used to list the beers. The recyclerView is populated by **cards** which contain information for each beer. The data for the cards is fetched from the **Punk API** and is then parsed using the **Gson** library.

## Challenge with JSON data
Fetching data from the API was very challenging. Various classes were created to create the request and handle the data such as **ApiService** and **MyRetrofitBuilder**. A data class called **Beer** was used to create the Beer objects that were used for the recyclerView. The Beer objects contain the name for each beer and other details. The `toString` method for the class was overriden for debugging purposes.

# Demo
- [Video Demo](https://youtu.be/MwbA9oJNOgE)
