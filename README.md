News App 

Tech & Toolset

• Clean Architecture

• MVVM

• Data Binding

• Room Database

• Dagger Hilt

•	Flow

• Retrofit

• Kotlin DSL

• Coroutines

• Glide

• LottieAnimations

•	split my app to modules each module have [ domain - data - presentation ] module

MultiModuleNewsApp
A News Application that leverages advanced modularization concepts, modern android toolset, and an open source API from newsapi.org. The modules are broken down by feature, namely headline news and news by search query.

Modularisation is done based in feature and then layer

app
Markup : ```javascript
         ```core
news-details
  data
  domain
  presentation
news
  data
  domain
  presentation
category
  data
  domain
  presentation
search
  data
  domain
  presentation


  News API
We using NEWS API to get data and show in app. Create your own API Key and replace NEWS_KEY in gradle.properties present in the project root.

NEWS_KEY="<NEWS_API_KEY>"
