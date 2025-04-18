plugins {
    java
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    implementation("io.javalin:javalin:6.1.3")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("io.javalin:javalin-rendering:6.1.3")
    implementation("gg.jte:jte:3.1.9")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass.set("org.example.hexlet.HelloWorld")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
