import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "fr.amoya.ktaglib"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // for now as a local dependency but will be uploaded to maven at some point
    implementation(files("../k-taglib/build/libs/k-taglib-jvm-1.0-SNAPSHOT.jar"))

    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.2")
    // Junit5 Test-Framework
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    testImplementation("org.testcontainers:testcontainers:1.15.3")
    testImplementation("org.testcontainers:junit-jupiter:1.15.3")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("fr.amoya.ktaglib.cli.MainKt")
}
