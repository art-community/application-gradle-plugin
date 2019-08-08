/*
 * Copyright 2019 ART
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ru.art.gradle.configurator.settings

import org.gradle.api.initialization.*
import ru.art.gradle.constants.*
import ru.art.gradle.context.Context.settingsConfiguration
import java.io.*

fun Settings.includeProjects() = settingsConfiguration.projectsPaths.forEach { path ->
    val projectsDirectory = File(path)
    projectsDirectory.listFiles()
            ?.filter { file ->
                file.isDirectory &&
                        !file.name.startsWith(DOT) &&
                        !file.name.endsWith(DOT) &&
                        file.listFiles()?.any { buildFile -> buildFile.name.contains(BUILD_GRADLE) } == true
            }
            ?.forEach { projectDir ->
                include(":${projectDir.name}");
                project(":${projectDir.name}").projectDir = projectDir
            }
    if (projectsDirectory.listFiles()?.any { file -> file.name.contains(BUILD_GRADLE) } == true) {
        include(":${projectsDirectory.name}")
        project(":${projectsDirectory.name}").projectDir = projectsDirectory
    }
}