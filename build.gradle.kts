plugins {
    groovy
    `java-library`
    `maven-publish`
}

group = "ru.chivo.mymath"
version = "1.2-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:3.0.5")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("myLibrary") {
            from(components["java"])
        }
    }

//    repositories {
//        maven {
//            name = "myRepo"
//            url = uri(layout.buildDirectory.dir("repo"))
//        }
//    }
}