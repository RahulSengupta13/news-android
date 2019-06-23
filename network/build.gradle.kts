plugins {
    kotlin("jvm")
}

dependencies {
    compile(kotlin("stdlib"))
    implementation(Libs.okhttp)
    implementation(Libs.gson)
    implementation(Libs.retrofit)
    implementation(Libs.logging_interceptor)
    implementation(Libs.converter_gson)
    implementation("com.squareup.retrofit2:converter-scalars:2.5.0")
}
