/*
 * ART Java
 *
 * Copyright 2019 ART
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

package ru.art.gradle.constants

import java.io.File.*

val SIMULATIONS_PATH = "src${separator}gatling${separator}simulations"
val GATLING_SOURCE_SET_DIR = "src${separator}gatling"
const val GATLING_CLASSPATH_FILE = "gatling-classpath.jar"
const val GATLING_CLASSPATH_TASK = "gatlingCreateClasspathJar"
const val LIBS_DIR = "libs"
const val SIMULATIONS_PACKAGE = "simulations"
const val SIMULATION_MARKER = "extends Simulation"
const val SCALA_SUFFIX = ".scala"
