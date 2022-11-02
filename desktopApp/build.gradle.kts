import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.3.0-alpha01-dev827"
}

group = "com.poddlybonk.organize"
version = "1.0.0"

kotlin {
    jvm {
        withJava()
    }

    sourceSets {
        named("jvmMain") {
            kotlin.srcDirs("src/jvmMain/kotlin")
            resources.srcDirs("src/jvmMain/resources")

            dependencies {
                implementation(project(":shared"))
                implementation(compose.desktop.currentOs)
            }
        }
        named("jvmTest") {
            dependencies {
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.uiTestJUnit4)
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            val resources = project.layout.projectDirectory.dir("src/jvmMain/resources")

            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            appResourcesRootDir.set(resources)
            packageName = "Organize"
            packageVersion = "1.0.0"

            macOS {
                bundleID = "com.poddlybonk.organize.desktop"
                iconFile.set(resources.file("macos-icon.icns"))
            }

            windows {
                iconFile.set(resources.file("windows-icon.ico"))
            }

            linux {
                iconFile.set(resources.file("linux-icon.png"))
            }
        }
    }
}

tasks.named<Copy>("jvmProcessResources") {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}
