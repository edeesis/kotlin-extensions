plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.21")
    id("maven-publish")
    id("signing")
}

repositories {
    mavenCentral()
    jcenter()
}

group = "com.edeesis"
version = "1.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
}

tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allJava)
}

publishing {
    publications {
        create<MavenPublication>("jar") {
            from(components["java"])
            artifact(tasks["sourcesJar"])
        }
    }

    repositories {
        mavenCentral()
        mavenLocal()
    }
}

signing {
    sign(publishing.publications["jar"])
}