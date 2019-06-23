buildscript {
    val kotlinVersion = "1.3.40"
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:3.4.1")
        classpath (kotlin("gradle-plugin", kotlinVersion))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}

plugins {
    id("de.fayard.buildSrcVersions") version "0.3.2"
}
