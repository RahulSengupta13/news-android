import kotlin.String

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Update this file with
 *   `$ ./gradlew buildSrcVersions` */
object Libs {
    /**
     * https://developer.android.com/topic/libraries/architecture/index.html */
    const val navigation_fragment_ktx: String = "android.arch.navigation:navigation-fragment-ktx:" +
            Versions.android_arch_navigation

    /**
     * https://developer.android.com/topic/libraries/architecture/index.html */
    const val navigation_ui_ktx: String = "android.arch.navigation:navigation-ui-ktx:" +
            Versions.android_arch_navigation

    /**
     * https://developer.android.com/topic/libraries/architecture/index.html */
    const val android_arch_paging_runtime: String = "android.arch.paging:runtime:" +
            Versions.android_arch_paging_runtime

    /**
     * http://developer.android.com/tools/extras/support-library.html */
    const val appcompat: String = "androidx.appcompat:appcompat:" + Versions.appcompat

    /**
     * https://developer.android.com/topic/libraries/architecture/index.html */
    const val core_testing: String = "androidx.arch.core:core-testing:" + Versions.core_testing

    /**
     * http://tools.android.com */
    const val constraintlayout: String = "androidx.constraintlayout:constraintlayout:" +
            Versions.constraintlayout

    /**
     * http://developer.android.com/tools/extras/support-library.html */
    const val core_ktx: String = "androidx.core:core-ktx:" + Versions.core_ktx

    /**
     * https://developer.android.com/topic/libraries/architecture/index.html */
    const val lifecycle_common: String = "androidx.lifecycle:lifecycle-common:" +
            Versions.androidx_lifecycle

    /**
     * https://developer.android.com/topic/libraries/architecture/index.html */
    const val lifecycle_extensions: String = "androidx.lifecycle:lifecycle-extensions:" +
            Versions.androidx_lifecycle

    /**
     * https://developer.android.com/topic/libraries/architecture/index.html */
    const val lifecycle_runtime: String = "androidx.lifecycle:lifecycle-runtime:" +
            Versions.androidx_lifecycle

    /**
     * http://developer.android.com/tools/extras/support-library.html */
    const val recyclerview: String = "androidx.recyclerview:recyclerview:" + Versions.recyclerview

    /**
     * https://developer.android.com/testing */
    const val androidx_test_runner: String = "androidx.test:runner:" + Versions.androidx_test_runner

    /**
     * https://developer.android.com/studio */
    const val com_android_tools_build_gradle: String = "com.android.tools.build:gradle:" +
            Versions.com_android_tools_build_gradle

    /**
     * https://developer.android.com/studio */
    const val lint_gradle: String = "com.android.tools.lint:lint-gradle:" + Versions.lint_gradle

    /**
     * http://developer.android.com/tools/extras/support-library.html */
    const val material: String = "com.google.android.material:material:" + Versions.material

    /**
     * https://github.com/google/gson */
    const val gson: String = "com.google.code.gson:gson:" + Versions.gson

    /**
     * https://github.com/JakeWharton/retrofit2-kotlin-coroutines-adapter/ */
    const val retrofit2_kotlin_coroutines_adapter: String =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:" +
            Versions.retrofit2_kotlin_coroutines_adapter

    /**
     * https://github.com/JakeWharton/timber */
    const val timber: String = "com.jakewharton.timber:timber:" + Versions.timber

    /**
     * https://github.com/square/okhttp */
    const val logging_interceptor: String = "com.squareup.okhttp3:logging-interceptor:" +
            Versions.com_squareup_okhttp3

    /**
     * https://github.com/square/okhttp */
    const val okhttp: String = "com.squareup.okhttp3:okhttp:" + Versions.com_squareup_okhttp3

    /**
     * https://github.com/square/picasso/ */
    const val picasso: String = "com.squareup.picasso:picasso:" + Versions.picasso

    /**
     * https://github.com/square/retrofit/ */
    const val converter_gson: String = "com.squareup.retrofit2:converter-gson:" +
            Versions.com_squareup_retrofit2

    /**
     * https://github.com/square/retrofit/ */
    const val retrofit: String = "com.squareup.retrofit2:retrofit:" +
            Versions.com_squareup_retrofit2

    const val de_fayard_buildsrcversions_gradle_plugin: String =
            "de.fayard.buildSrcVersions:de.fayard.buildSrcVersions.gradle.plugin:" +
            Versions.de_fayard_buildsrcversions_gradle_plugin

    /**
     * http://junit.org */
    const val junit: String = "junit:junit:" + Versions.junit

    /**
     * https://kotlinlang.org/ */
    const val kotlin_android_extensions_runtime: String =
            "org.jetbrains.kotlin:kotlin-android-extensions-runtime:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_android_extensions: String =
            "org.jetbrains.kotlin:kotlin-android-extensions:" + Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_annotation_processing_gradle: String =
            "org.jetbrains.kotlin:kotlin-annotation-processing-gradle:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_gradle_plugin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://kotlinlang.org/ */
    const val kotlin_stdlib_jdk7: String = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:" +
            Versions.org_jetbrains_kotlin

    /**
     * https://github.com/Kotlin/kotlinx.coroutines */
    const val kotlinx_coroutines_android: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:" + Versions.org_jetbrains_kotlinx

    /**
     * https://github.com/Kotlin/kotlinx.coroutines */
    const val kotlinx_coroutines_core: String = "org.jetbrains.kotlinx:kotlinx-coroutines-core:" +
            Versions.org_jetbrains_kotlinx
}