import org.gradle.api.JavaVersion

object ConfigData {
    const val compileSdkVersion = 32
    const val minSdkVersion = 23
    const val targetSdkVersion = 32
    val jvmTarget = "${JavaVersion.VERSION_1_8}"
    const val buildToolsVersion = "30.0.3"
}