plugins {
    java
    kotlin("multiplatform") version "1.3.21"
}

dependencies {
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:1.2.1")
}

repositories {
    jcenter()
    mavenCentral()
}

kotlin {
  iosX64("native") {
    binaries {
      framework {
        baseName = "Lib"
      }
    }
  }
}

tasks.withType<Wrapper> {
  gradleVersion = "5.3.1"
  distributionType = Wrapper.DistributionType.ALL
}