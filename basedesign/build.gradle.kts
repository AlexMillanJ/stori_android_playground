plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Modules.Spaces.bdSpace
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
     * Activity
     */
    implementation(Dependencies.compose_activity)

    /**
     * Appcompat
     */
    implementation(Dependencies.appCompat)

    /**
     * Compose
     */
    implementation(Dependencies.compose_lottie)
    implementation(Dependencies.compose_constraint)
    implementation(Dependencies.compose_constraint_compose)
    implementation(Dependencies.compose_constraint_core)
    implementation(Dependencies.compose_foundation)
    implementation(Dependencies.compose_lottie)
    implementation(Dependencies.compose_material)
    implementation(Dependencies.compose_ui)
    implementation(Dependencies.compose_tooling_preview)

    /**
     * Lifecycle
     */
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.lifecycleExtensions)
}