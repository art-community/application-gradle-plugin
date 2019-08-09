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

package ru.art.gradle.configurator.project

import org.gradle.api.*
import org.gradle.api.tasks.testing.*
import org.gradle.kotlin.dsl.*
import ru.art.gradle.constants.*
import ru.art.gradle.constants.DependencyConfiguration.*
import ru.art.gradle.context.Context.projectConfiguration
import ru.art.gradle.logging.*
import ru.art.gradle.provider.*

fun Project.configureTests() {
    addDependency(TEST_COMPILE_CLASSPATH, junit())

    with(testTask()) {
        if (projectConfiguration().testsConfiguration.useJunit) {
            useJUnit()
            success("Use JUnit in tests")
        }

        beforeTest(closureOf<TestDescriptor> {
            logger.lifecycle(this.toString())
        })

        onOutput(KotlinClosure2<TestDescriptor, TestOutputEvent, Unit>({ descriptor, event ->
            logger.lifecycle("$descriptor - ${event.message}")
        }))
    }

    if (!projectConfiguration().testsConfiguration.buildDependsOnTest) {
        buildTask().dependsOn.remove(testTask())
        additionalAttention("Disable 'test' task before 'build' task")
    }
    if (!projectConfiguration().testsConfiguration.buildDependsOnCheck) {
        buildTask().dependsOn.remove(checkTask())
        additionalAttention("Disable 'check' task before 'build' task")
    }
}