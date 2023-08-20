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

![image](https://github.com/kbrakendirci/MultimoduleExampleApp/assets/43795927/ac57f37f-4818-4519-8bfb-cd4d5fcbf61b)


MultiModuleNewsApp
A News Application that leverages advanced modularization concepts, modern android toolset, and an open source API from newsapi.org. The modules are broken down by feature, namely headline news and news by search query.

Modularisation is done based in feature and then layer

app

<ul>
<li>core</li>
  <ul>
<li>bar</li>
<li>baz</li>
<li>boo</li>
  </ul>
</ul>

<ul>
<li>core</li>
<li>news</li>
  <ul>
<li>data</li>
<li>domain</li>
<li>presentation</li>
  </ul>
<li>news-details</li>
<li>search</li>
<li>category</li>
</ul>



•news-details

     data
  
     domain
  
     presentation
  
•news-details

    data
  
    domain
  
    presentation
  
  
•search

   data
  
   domain
  
   presentation


