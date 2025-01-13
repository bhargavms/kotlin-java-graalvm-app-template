plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

kotlin {
    jvmToolchain(21)
}

val Provider<PluginDependency>.dependency
    get() = map { "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}" }

dependencies {
    implementation(libs.plugins.kotlin.dependency)
    implementation(libs.plugins.graalvm.dependency)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}