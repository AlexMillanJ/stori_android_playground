plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = Modules.Spaces.moduleTUiSpace
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            consumerProguardFiles("consumer-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtension
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/INDEX.LIST/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    /**
     * Other modules
     */
    implementation(project(Modules.baseDesign))
    implementation(project(Modules.platformBase))

    /**
     * Activity
     */
    implementation(Dependencies.activityKtx)

    /**
     * Appcompat
     */
    implementation(Dependencies.appCompat)

    /**
     * Compose
     */
    implementation(Dependencies.compose_activity)
    implementation(Dependencies.compose_constraint_compose)
    implementation(Dependencies.compose_constraint_core)
    implementation(Dependencies.compose_foundation)
    implementation(Dependencies.compose_lottie)
    implementation(Dependencies.compose_material)
    implementation(Dependencies.compose_navigation)
    implementation(Dependencies.compose_ui)
    //implementation(Dependencies.compose_tooling_preview)

    /**
     * Constraint
     */
    implementation(Dependencies.constraint)

    /**
     * Coroutines
     */
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)

    /**
     * Fragments
     */
    implementation(Dependencies.fragmentKtx)

    /**
     * Glide
     */
    implementation(Dependencies.glide)
    kapt(Dependencies.glideCompiler)

    /**
     * Hilt
     */
    implementation(Dependencies.hilt)
    kapt(Dependencies.daggerHiltCompiler)
    implementation(Dependencies.hiltNavigationCompose)

    /**
     * Lifecycle
     */
    implementation(Dependencies.lifecycleViewModel)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.lifecycleLiveData)
    implementation(Dependencies.lifecycleExtensions)

    /**
     * Lottie
     */
    implementation(Dependencies.lottie)

    /**
     * Material
     */
    implementation(Dependencies.material)

    /**
     * OkkHttp
     */
    implementation(Dependencies.okHttp)
    implementation(Dependencies.loggingInterceptor)

    /**
     * Reactive Network
     */
    implementation(Dependencies.reactiveNetwork)

    /**
     * Recyclers
     */
    implementation(Dependencies.recycler)
    implementation(Dependencies.recyclerSelection)

    /**
     * Retrofit
     */
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConverter)
    implementation(Dependencies.retrofitRxAdapter)

    /**
     * Serialization
     */
    implementation(Dependencies.serialization)
}