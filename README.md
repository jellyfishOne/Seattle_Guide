# Seattle_Guide
A guide to popular breweries, restaurants, and hiking spots near Seattle, Washington

This is my second android application (hooray)!

For this application, I used a custom ArrayAdapter to display the data of each Location object. Because I only used four categories (Food, Beer, touristy, and hiking) I decided to use a FragmentPageAdapter to display each category; This way, the user can swipe between each category more easily.

I also used an onItemClickListener to launch an ActionView intent when a location is clicked on. The intent opens a Maps application to the location’s geo location.  

The application was built on Android Studio, Android SDK v26, and Android Build Tools 26.0.0
