import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val android_arch_navigation: String = "1.0.0" 

    const val android_arch_paging_runtime: String = "1.0.1" 

    const val appcompat: String = "1.1.0-alpha03" 

    const val core_testing: String = "2.0.1" 

    const val constraintlayout: String = "1.1.3" 

    const val core_ktx: String = "1.1.0-alpha04" 

    const val androidx_lifecycle: String = "2.0.0" 

    const val recyclerview: String = "1.0.0" 

    const val androidx_test_runner: String = "1.2.0" 

    const val com_android_tools_build_gradle: String = "3.4.1" 

    const val lint_gradle: String = "26.4.1" 

    const val material: String = "1.1.0-alpha07" 

    const val gson: String = "2.8.5" 

    const val retrofit2_kotlin_coroutines_adapter: String = "0.9.2" 

    const val timber: String = "4.7.1" 

    const val com_squareup_okhttp3: String = "3.14.2" 

    const val picasso: String = "2.71828" 

    const val com_squareup_retrofit2: String = "2.6.0" 

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.3.2" 

    const val junit: String = "4.12" 

    const val org_jetbrains_kotlin: String = "1.3.40" 

    const val org_jetbrains_kotlinx: String = "1.2.2" 

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.1.1"

        const val currentVersion: String = "5.4.1"

        const val nightlyVersion: String = "5.6-20190623000042+0000"

        const val releaseCandidate: String = "5.5-rc-3"
    }
}
