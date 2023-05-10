object Dependencies {

    /**
     * Activity
     */
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"

    /**
     * AppCompat
     */
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    /**
     * ARouter
     */
    const val arouter = "com.alibaba:arouter-api:${Versions.Libs.arouter}"
    const val arouterCompiler = "com.alibaba:arouter-compiler:${Versions.Libs.arouter}"

    /**
     * AWS
     */
    const val aws_core = "com.amazonaws:aws-android-sdk-core:${Versions.Libs.aws_core}"
    const val aws_cognito = "com.amazonaws:aws-android-sdk-cognito:${Versions.Libs.aws_cognito}"
    const val aws_cognito_identity_provider =
        "com.amazonaws:aws-android-sdk-cognitoidentityprovider:${Versions.Libs.aws_core}"
    const val aws_pinpoint = "com.amazonaws:aws-android-sdk-pinpoint:${Versions.Libs.aws_core}"
    const val aws_auth_core =
        "com.amazonaws:aws-android-sdk-auth-core:${Versions.Libs.aws_auth_core}"
    const val aws_s3 = "com.amazonaws:aws-android-sdk-s3:${Versions.Libs.aws_core}"
    const val aws_cognito_auth =
        "com.amazonaws:aws-android-sdk-cognitoauth:${Versions.Libs.aws_auth_core}"

    /**
     * Compose
     */
    const val compose_ui = "androidx.compose.ui:ui:${Versions.Libs.compose_ui}"
    const val compose_material =
        "androidx.compose.material:material:${Versions.Libs.compose_material}"
    const val compose_activity =
        "androidx.activity:activity-compose:${Versions.Libs.compose_activity}"
    const val compose_foundation =
        "androidx.compose.foundation:foundation:${Versions.Libs.compose_foundation}"
    const val compose_hilt_navigation =
        "androidx.hilt:hilt-navigation-compose:${Versions.Libs.compose_hilt_navigation}"
    const val compose_lottie = "com.airbnb.android:lottie-compose:${Versions.Libs.compose_lottie}"
    const val compose_navigation =
        "androidx.navigation:navigation-compose:${Versions.Libs.compose_navigation}"
    const val compose_constraint_compose =
        "androidx.constraintlayout:constraintlayout-compose" +
                ":${Versions.Libs.compose_constraint_compose}"
    const val compose_constraint_core =
        "androidx.constraintlayout:constraintlayout-core:${Versions.Libs.compose_constraint_core}"

    /**
     * Constraint
     */
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"

    /**
     * Coroutines
     */
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Libs.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Libs.coroutines}"

    /**
     * Firebase
     */
    const val firebaseDynamicLinks =
        "com.google.firebase:firebase-dynamic-links:${Versions.Libs.firebaseDynamicLinks}"
    const val firebaseCrashlytics =
        "com.google.firebase:firebase-crashlytics:${Versions.Libs.firebaseCrashlytics}"

    /**
     * Fragment
     */
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    /**
     * Glide
     */
    const val glide = "com.github.bumptech.glide:glide:${Versions.Libs.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.Libs.glide}"


    /**
     * Hilt
     */
    const val hilt = "com.google.dagger:hilt-android:${Versions.Libs.hilt}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin${Versions.Libs.hilt}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Libs.hilt}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.Libs.hiltCompiler}"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.Libs.hiltNavigationCompose}"

    /**
     * Lifecycle
     */
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Libs.lifecycleVersion}"
    const val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Libs.lifecycleVersion}"
    const val lifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.Libs.lifecycleExtensions}"
    const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Libs.lifecycleVersion}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Libs.lifecycleVersion}"

    /**
     * Lottie
     */
    const val lottie = "com.airbnb.android:lottie:${Versions.Libs.lottie}"

    /**
     * Material
     */
    const val material = "com.google.android.material:material:${Versions.Libs.material}"

    /**
     * OkkHttp3
     */
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.Libs.okhttp}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.Libs.okhttp}"

    /**
     * Reactive Network
     */
    const val reactiveNetwork =
        "com.github.pwittchen:reactivenetwork-rx2:${Versions.Libs.reactiveNetwork}"

    /**
     * Recyclers
     */
    const val recycler = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val recyclerSelection =
        "androidx.recyclerview:recyclerview-selection:${Versions.recyclerSelection}"

    /**
     * Retrofit
     */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Libs.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.Libs.retrofit}"
    const val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.Libs.retrofit}"

    /**
     * Serialization
     */
    const val serialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Libs.jsonSerialization}"
}