plugins {
    id(libs.plugins.convention.kotlin.jvm.get().pluginId)
    id(libs.plugins.convention.graal.get().pluginId)
    application
}

group = "dev.mogra.sample.app"
version = "0.1.0"

application {
    mainClass.set("dev.mogra.sample.app.SampleAppKt")
}

graalvm {
   mainClass = "dev.mogra.sample.app.SampleAppKt"
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.coroutines)

    testImplementation(libs.kotlin.test)
    testImplementation(libs.junit.jupiter)
}
