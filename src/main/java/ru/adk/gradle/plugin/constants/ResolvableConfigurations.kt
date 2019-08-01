package ru.adk.gradle.plugin.constants

import ru.adk.gradle.plugin.constants.DependencyConfiguration.*

val RESOLVABLE_CONFIGURATIONS = setOf(COMPILE_CLASSPATH.configuration, RUNTIME_CLASSPATH.configuration, TEST_COMPILE_CLASSPATH.configuration, TEST_RUNTIME_CLASSPATH.configuration, EMBEDDED.configuration, PROVIDED.configuration)