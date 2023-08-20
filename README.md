News App 

Kullanılan Teknolojiler :

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

Modül Oluşturmak

1-)Android studio üzerinde Go to file -> News -> News Module -> Android Library -> Modül ismi verilir (news )


2-)News modülünün altında yeni modüller (news_data, news_domain, news_presentation) oluşturulur.


3-)Aynı adımlar search,category,common modülleri için tekrarlanır.

![image](https://github.com/kbrakendirci/MultimoduleExampleApp/assets/43795927/0480d193-9e9a-48e6-9d95-d5ef1fa0a23e)


Build.Gradle

Kotlin ile derleme mantığımızı sorunsuz bir şekilde yazmak ve Gradle dosyalarına eklemek için kotlin-dsl eklentisinden de yararlanacağız.
Çok modüllü projelerde benzer içeriklere sahip builds.gradle dosyaları bulunur. Aynı kütüphaneye bağlı birden fazla modül varsa,kütüphanenin sürümünü ortak bir classtan kolayca alabilir. Bu nedenle buildSrc dizini ve build.gradle.kts dosyası oluşturulur.

1-) MultiModuleExampleApp ana modülü -> New -> Directory ->buildSrc isimli dizin oluşturulur.

2-) Oluşturulan dizin altında build.gradle.kts isimli dosya oluşturulur.

3-) buildSrc->NewDirectory-> src/main/java klasörleri oluşturulur.

4-) Java dizininin altında Dependencies isimli class oluşturulur.

![image](https://github.com/kbrakendirci/MultimoduleExampleApp/assets/43795927/1bcade89-b10d-49f1-be31-cdf2ccafbac0)


5-) Kullanılmak istenen kütüphanelerin sürümlerini Dependencies.kt dosyasına ekleyin;

```
object Versions {
    const val core = "1.9.0"
    const val appcompat = "1.5.1"
    const val androidMaterial = "1.6.1"
    const val constraintLayout = "2.1.4"

    const val testImplJunit = "4.13.2"
    const val androidTestImplJunit = "1.1.3"
    const val androidTestEspresso = "3.4.0"

    const val retrofit = "2.9.0"
    const val gsonConvertor = "2.9.0"
    const val okHttp = "4.9.0"
    const val scalerConvertor = "2.1.0"
    const val retrofitInterceptorVersion="5.0.0-alpha.10"

    const val kotlinCoroutines = "1.6.1"

    const val coroutineLifecycleScope = "2.5.1"

    const val glide = "4.12.0"

    const val viewModelDeligate = "1.6.0"

    const val dagger = "2.44"
    const val hiltCompiler = "1.0.0"

    const val roomVersion = "2.4.3"

    const val swipeRefresh = "1.1.0"

    const val lottieAnimations = "3.4.2"
}

object Deps {

    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

}

object TestImplementation {

    const val junit = "junit:junit:${Versions.testImplJunit}"
}

object AndroidTestImplementation {

    const val junit = "androidx.test.ext:junit:${Versions.androidTestImplJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}"

}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Versions.gsonConvertor}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val scalersConvertors = "com.squareup.retrofit2:converter-scalars:${Versions.scalerConvertor}"
    const val okHttpLog = "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitInterceptorVersion}"
    const val   retrofitVersion = "2.9.0"
    const val moshiVersion = "1.13.0"
    const val gsonVersion = "2.9.1"
    const val retrofitInterceptorVersion = "5.0.0-alpha.10"
    const val moshiConverterVersion = "2.9.0"
}

object Coroutines {
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
}

object CoroutinesLifecycleScope {
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.coroutineLifecycleScope}"
    const val lifeCycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutineLifecycleScope}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val annotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object ViewModelDelegate {
    const val viewModelDeligate = "androidx.activity:activity-ktx:${Versions.viewModelDeligate}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
}

object Room {
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val room = "androidx.room:room-ktx:${Versions.roomVersion}"
}

object CircularProgressBar {
    const val swipeRefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
}

object LottieAnimations {
    const val lottieAnimations = "com.airbnb.android:lottie:${Versions.lottieAnimations}"
}

```

