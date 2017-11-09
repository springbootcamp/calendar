import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenLocal()
		mavenCentral()
		maven("https://repo.spring.io/milestone")
	}

	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.M6")
		classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.1")
    classpath("org.springframework:springloaded:1.2.6.RELEASE")
	}
}

apply {
  plugin("idea")
	plugin("org.springframework.boot")
	plugin("org.junit.platform.gradle.plugin")
}

//idea {
//  module {
//    inheritOutputDirs = false
//    outputDir = file("$buildDir/classes/main/")
//  }
//}

plugins {
	val kotlinVersion = "1.1.51"
	id("org.jetbrains.kotlin.jvm") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
	id("io.spring.dependency-management") version "1.0.3.RELEASE"
}

version = "0.1.0-SNAPSHOT"

tasks {
	withType<KotlinCompile> {
		kotlinOptions {
			jvmTarget = "1.8"
			freeCompilerArgs = listOf("-Xjsr305=strict")
		}
	}
}

repositories {
	mavenLocal()
	mavenCentral()
	maven("http://repo.spring.io/milestone")
}

dependencies {
	compile("org.springframework.boot:spring-boot-starter-web")
	compile("org.springframework.boot:spring-boot-starter-data-jpa")
	compile("com.h2database:h2")
	compile("org.jetbrains.kotlin:kotlin-stdlib")
	compile("org.jetbrains.kotlin:kotlin-reflect")
	testCompile("org.springframework.boot:spring-boot-starter-test") {
		exclude(module = "junit")
	}
	testCompile("org.junit.jupiter:junit-jupiter-api")
	testRuntime("org.junit.jupiter:junit-jupiter-engine")
}
