plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "me.rahulsengupta.news"
        minSdkVersion(24)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

androidExtensions {
    isExperimental = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.kotlin_stdlib_jdk7)
    implementation(Libs.appcompat)
    implementation(Libs.core_ktx)
    implementation(Libs.kotlinx_coroutines_core)
    implementation(Libs.kotlinx_coroutines_android)
    implementation(Libs.junit)
    implementation(Libs.androidx_test_runner)
    implementation(Libs.timber)
    implementation(Libs.lifecycle_extensions)
    implementation(Libs.android_arch_paging_runtime)

    implementation(Libs.constraintlayout)
    implementation(Libs.material)
    implementation(Libs.recyclerview)

    implementation(Libs.navigation_fragment_ktx)
    implementation(Libs.navigation_ui_ktx)

    implementation(Libs.okhttp)
    implementation(Libs.picasso)
    implementation(Libs.gson)
    implementation(Libs.retrofit)
    implementation(Libs.logging_interceptor)
    implementation(Libs.converter_gson)
    implementation(Libs.retrofit2_kotlin_coroutines_adapter)

    testImplementation(Libs.core_testing)

    androidTestImplementation(Libs.lifecycle_common)
    androidTestImplementation(Libs.lifecycle_runtime)
}

repositories {
    mavenCentral()
    maven("http://repository.jetbrains.com/all")
}
