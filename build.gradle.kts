import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    kotlin("jvm") version "2.1.20"
    id("org.openapi.generator") version "7.12.0"
}

group = "com.grassehh"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

tasks.compileKotlin {
    dependsOn("openApiGenerateKotlin")
}

task<GenerateTask>("openApiGenerateKotlin") {
    generatorName.set("kotlin-spring")
    inputSpec.set("openapi.yaml")
    outputDir.set("${layout.buildDirectory.asFile.get()}/generated")
    modelPackage.set("com.grassehh.api.model")
    generateApiDocumentation.set(false)
    generateModelDocumentation.set(false)
    generateApiTests.set(false)
    generateModelTests.set(false)
    globalProperties.set(mapOf(Pair("models", "")))
}