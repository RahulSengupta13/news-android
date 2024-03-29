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

            val News_NewsOrg_ApiKey: String by project
            buildConfigField("String", "NewsOrgApiKey", News_NewsOrg_ApiKey)
        }
        getByName("debug") {
            val News_NewsOrg_ApiKey: String by project
            buildConfigField("String", "NewsOrgApiKey", News_NewsOrg_ApiKey)
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
    implementation(project(":network"))

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

    implementation(Libs.okhttp)
    implementation(Libs.gson)
    implementation(Libs.retrofit)
    implementation(Libs.logging_interceptor)
    implementation(Libs.converter_gson)

    implementation(Libs.constraintlayout)
    implementation(Libs.material)
    implementation(Libs.recyclerview)

    implementation(Libs.navigation_fragment_ktx)
    implementation(Libs.navigation_ui_ktx)

    implementation("androidx.room:room-runtime:2.1.0")
    implementation("androidx.room:room-ktx:2.1.0")
    kapt("androidx.room:room-compiler:2.1.0")

    /*DI*/
    implementation("org.koin:koin-android:2.0.1")
    implementation("org.koin:koin-android-viewmodel:2.0.1")

    implementation("android.arch.paging:runtime:1.0.1")
    implementation("com.mikhaellopez:circularimageview:4.0.1")
    implementation("joda-time:joda-time:2.10.2")
    implementation("com.github.ar-android:AndroidSvgLoader:1.0.2")

    implementation(Libs.picasso)
    implementation(Libs.retrofit2_kotlin_coroutines_adapter)

    testImplementation(Libs.core_testing)

    androidTestImplementation(Libs.lifecycle_common)
    androidTestImplementation(Libs.lifecycle_runtime)
}

repositories {
    mavenCentral()
    maven("http://repository.jetbrains.com/all")
    maven("https://jitpack.io")
}
