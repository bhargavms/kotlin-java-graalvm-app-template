val taskGroup = "build-logic build"

tasks.register("compileAll") {
    group = taskGroup
    description = "Compile all code of the '${project.path}' component"

    dependsOn(
        subprojects
            .filter(::isPlainDir)
            .map { "${it.path}:compileKotlin" }
    )
}

tasks.register("assembleAll") {
    group = taskGroup
    description = "Assemble '${project.path}' component"

    dependsOn(
        subprojects
            .filter(::isPlainDir)
            .map { "${it.path}:assemble" }
    )
}

tasks.register("checkAll") {
    group = taskGroup
    description = "Run all tests and static analysis tools on '${project.path}' component"

    dependsOn(
        subprojects
            .filterNot(::isPlainDir)
            .map { "${it.path}:check" }
    )
}

tasks.register("build") {
    setDependsOn(gradle.includedBuilds.map { it.task(":build") })
}

tasks.register("clean", Delete::class) {
    setDependsOn(gradle.includedBuilds.map { it.task(":clean") })
    delete(rootProject.layout.buildDirectory)
}

fun isPlainDir(project: Project) =
    !project.file("build.gradle").exists() && !project.file("build.gradle.kts").exists()