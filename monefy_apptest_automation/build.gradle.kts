plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.monefy"
version = "1.0"

repositories {
    mavenCentral()
    google()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    implementation("io.appium:java-client:8.3.0")
    implementation("org.slf4j:slf4j-simple:2.0.7")
}

tasks.test {
    useJUnitPlatform()
}
