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

package io.art.gradle.external.constants

const val BUILD_EXECUTABLE_JAR_TASK = "build-executable-jar"
const val BUILD_EXECUTABLE_NATIVE_TASK = "build-executable-native"

const val RUN_EXECUTABLE_JAR_TASK = "run-executable-jar"
const val RUN_EXECUTABLE_NATIVE_TASK = "run-executable-native"
const val RUN_WITH_NATIVE_IMAGE_AGENT = "run-executable-with-native-agent"

const val EMBEDDED_CONFIGURATION_NAME = "embedded"
const val IMPLEMENTATION_CONFIGURATION_NAME = "implementation"

const val MAIN_CLASS_MANIFEST_ATTRIBUTE = "Main-Class"
const val MULTI_RELEASE_MANIFEST_ATTRIBUTE = "Multi-Release"

const val BUILD = "build"
const val JAR = "jar"
const val EXECUTABLE = "executable"

val DEFAULT_JAR_EXCLUSIONS = setOf("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA", "META-INF/**.RSA", "META-INF/MANIFEST.MF")

const val JAVA_GROUP = "io.art.java"
const val KOTLIN_GROUP = "io.art.kotlin"

enum class ArtVersion(val version: String) {
    MAIN("main")
}

enum class JavaModules(val artifact: String) {
    CORE("core"),
    LOGGING("logging"),
    VALUE("value"),
    SCHEDULER("scheduler"),
    CONFIGURATOR("configurator"),
    JSON("json"),
    PROTOBUF("protobuf"),
    MESSAGE_PACK("message-pack"),
    YAML_CONFIGURATION("yaml-configuration"),
    YAML("yaml"),
    RESILIENCE("resilience"),
    TRANSPORT("transport"),
    SERVER("server"),
    COMMUNICATOR("communicator"),
    HTTP("http"),
    RSOCKET("rsocket"),
    ROCKS_DB("rocks-db"),
    TARANTOOL("tarantool"),
    META("meta"),
    GRAAL("graal"),
    STORAGE("storage"),
    MODEL("model"),
    LAUNCHER("launcher")
}

enum class KotlinModules(val artifact: String) {
}

const val KOTLIN_JVM_PLUGIN_ID = "org.jetbrains.kotlin.jvm"

const val DOLLAR = "$"
const val OS_ARCH_PROPERTY = "os.arch"
const val CONFIGURATION = "configuration"
const val DOT_EXE = ".exe"
const val DOT_JAR = ".jar"
const val DOT_LOCK = ".lock"
const val POWERSHELL = "powershell"
const val JAR_OPTION = "-jar"

const val TAR = "tar"
const val TAR_EXTRACT_ZIP_OPTIONS = "xzf"
const val TAR_DIRECTORY_OPTION = "-C"
