package ru.adk.gradle.plugin.configurator.settings

import org.gradle.api.initialization.Settings
import ru.adk.gradle.plugin.constants.BUILD_GRADLE
import ru.adk.gradle.plugin.constants.DOT
import ru.adk.gradle.plugin.context.Context.settingsConfiguration
import java.io.File

fun Settings.includeProjects() = settingsConfiguration.projectsPaths.forEach { path ->
    val projectsDirectory = File(path)
    projectsDirectory.listFiles()
            ?.filter { file -> file.isDirectory && !file.name.startsWith(DOT) && !file.name.endsWith(DOT) && file.listFiles()?.any { buildFile -> buildFile.name.contains(BUILD_GRADLE) } == true }
            ?.forEach { projectDir -> include(":${projectDir.name}"); project(":${projectDir.name}").projectDir = projectDir }
    if (projectsDirectory.listFiles()?.any { file -> file.name.contains(BUILD_GRADLE) } == true) {
        include(":${projectsDirectory.name}")
        project(":${projectsDirectory.name}").projectDir = projectsDirectory
    }
}