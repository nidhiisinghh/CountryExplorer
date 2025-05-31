# 🌎 Country Explorer 📱✨

Welcome to the **Country Explorer** app! This Android application allows you to discover and explore information about countries around the world using the REST Countries API. Find details about their population, region, capital, currency, languages, and more! 🎉🗺️

## 📜 Features

-   **Home Screen:**
    -   Fetch and display a list of all countries. 🌐
    -   Show country name, flag, region, and population. 📊🚩
    -   Scrollable list using RecyclerView. 📜
-   **Country Detail Screen:**
    -   View detailed information about a selected country: Name, Capital, Region, Population, Area, Currency, Languages. 🏛️🏘️🗣️💰
    -   Display the country's flag prominently. 🖼️
-   **Basic Error Handling:**
    -   Show a loading spinner while data is being fetched. 🔄
    -   Display a message if there's an error (e.g., no internet). ⚠️📶

## 🌐 API

This app uses the free [REST Countries API](https://restcountries.com/) to fetch country data. 📡

-   **Endpoint:** `https://restcountries.com/v3.1/all`

## 🏗️ Architecture & Concepts

-   **API Integration:** Retrofit for fetching data from the API. 📦📬
-   **Asynchronous Operations:** Kotlin Coroutines for managing background tasks. 💪⚡
-   **UI:** RecyclerView for efficient list display. 📜
-   **Design Pattern:** Follows MVVM (Model-View-ViewModel) principles (ViewModel not explicitly shown in attached code, but can be added for better separation of concerns). 🧱🏗️
-   **Image Loading:** Glide for efficiently loading flag images. 🏞️🚀

Enjoy exploring the world! 🥳✨
