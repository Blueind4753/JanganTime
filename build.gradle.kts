plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
    id("com.gradleup.shadow") version "8.3.5"
}

group = "me.blueind"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

javafx {
    version = "21.0.5"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
}

application {
    mainClass.set("me.blueind.Main")
}

tasks.shadowJar {
    mergeServiceFiles()
    manifest {
        attributes(
            "Main-Class" to "me.blueind.Main"
        )
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}