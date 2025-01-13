package dev.mogra.gradle.graal

import org.gradle.api.provider.Property

// First, create an extension
abstract class GraalVMExtension {
    abstract val mainClass: Property<String>
}