/*
 * ART
 *
 * Copyright 2019-2021 ART
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.art.gradle.common.configuration

import io.art.gradle.common.constants.*
import io.art.gradle.common.constants.GeneratorLanguages.JAVA
import org.gradle.api.Project
import org.gradle.api.file.SourceDirectorySet
import org.gradle.api.model.ObjectFactory
import org.gradle.api.tasks.SourceSet
import java.nio.file.Path
import java.time.Duration
import javax.inject.Inject

open class GeneratorConfiguration @Inject constructor(project: Project, objectFactory: ObjectFactory) {
    var configurationPath: Path = project.rootProject.buildDir.resolve(GENERATOR).resolve(MODULE_YML).toPath()
        private set

    var watcherPeriod: Duration = DEFAULT_WATCHER_PERIOD
        private set

    var loggingDirectory: Path = project.buildDir.resolve(GENERATOR).toPath()
        private set

    var sourceSets = mutableMapOf<GeneratorLanguages, MutableSet<Path>>()
        private set

    fun watcherPeriod(period: Duration) {
        watcherPeriod = period
    }

    fun loggingDirectory(directory: Path) {
        loggingDirectory = directory
    }

    fun configurationPath(path: Path) {
        configurationPath = path
    }

    fun java(source: SourceDirectorySet) {
        sourceSets.putIfAbsent(GeneratorLanguages.JAVA, mutableSetOf())!!.add(source.sourceDirectories.first().toPath())
    }

    fun kotlin(source: SourceDirectorySet) {
        sourceSets.putIfAbsent(GeneratorLanguages.KOTLIN, mutableSetOf())!!.add(source.sourceDirectories.first().toPath())
    }

    fun dart(source: SourceDirectorySet) {
        sourceSets.putIfAbsent(GeneratorLanguages.DART, mutableSetOf())!!.add(source.sourceDirectories.first().toPath())
    }
}
