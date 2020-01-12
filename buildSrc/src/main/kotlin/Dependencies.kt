object Versions {
    const val minSdkVersion = 23
    const val targetSdkVersion = 29

    const val kotlin = "1.3.61"
    const val coroutinesVersion = "1.3.2"

    const val androidxAppcompat = "1.1.0"
    const val androidxCore = "1.1.0"
    const val composeVersion = "0.1.0-dev03"
    const val androidxActivity = "1.1.0-rc02"

    const val daggerVersion = "2.25.2"
    const val okhttpVersion = "4.2.2"
    const val retrofitVersion = "2.6.2"
    const val moshiVersion = "1.9.1"

    const val junit = "4.12"
    const val androidTestJunit = "1.1.1"
}

object Dependencies {

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"

    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinSerializationRuntime = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.14.0"

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAndroid =  "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

    const val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidxActivity = "androidx.activity:activity-ktx:${Versions.androidxActivity}"

    const val androidxComposeRuntime = "androidx.compose:compose-runtime:${Versions.composeVersion}"
    const val androidxUiFramework = "androidx.ui:ui-framework:${Versions.composeVersion}"
    const val androidxUiLayout = "androidx.ui:ui-layout:${Versions.composeVersion}"
    const val androidxUiMaterial = "androidx.ui:ui-material:${Versions.composeVersion}"
    const val androidxUiFoundation = "androidx.ui:ui-foundation:${Versions.composeVersion}"
    const val androidxUiAnimation = "androidx.ui:ui-animation:${Versions.composeVersion}"
    const val androidxUiTooling = "androidx.ui:ui-tooling:${Versions.composeVersion}"


    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"

    const val okhttpCore = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okhttpLoggingInterceptor =  "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    const val retrofitCore = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.4.0"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:2.0-beta-3"
    const val timber = "com.jakewharton.timber:timber:4.7.1"

    const val junit = "junit:junit:${Versions.junit}"
    const val androidTestJunit = "androidx.test.ext:junit:${Versions.androidTestJunit}"
}