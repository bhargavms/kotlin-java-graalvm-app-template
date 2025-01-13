package dev.mogra.gradle

import dev.mogra.gradle.graal.GraalVMExtension
import gradle.kotlin.dsl.accessors._6d05c7e64213bdbda167c98aa0a44dac.graalvmNative
import gradle.kotlin.dsl.accessors._6d05c7e64213bdbda167c98aa0a44dac.metadataRepository
import org.gradle.kotlin.dsl.create

plugins {
    id("org.graalvm.buildtools.native")
}
private val graalvmConfig = extensions.create<GraalVMExtension>("graalvm")
graalvmNative {
    binaries {
        named("main") {
            imageName.set(project.name)
            mainClass.set(graalvmConfig.mainClass)
            debug.set(System.getProperty("debug") != null)
            buildArgs.addAll(
                "--no-fallback",
                "-H:+ReportExceptionStackTraces",
                "--enable-url-protocols=http,https"
            )
            verbose.set(true)
        }
    }
    metadataRepository {
        enabled.set(true)
    }
}