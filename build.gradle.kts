import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"

	// 현 gradle 은 kotlin 1.9.23 까지만 지원
	kotlin("plugin.jpa") version "1.9.23"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
	kotlin("kapt") version "1.9.23"

	idea
}
group = "com.projectbusan"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation ("io.jsonwebtoken:jjwt-api:0.11.2")
	implementation ("io.jsonwebtoken:jjwt-jackson:0.11.2")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
	implementation("com.google.code.gson:gson")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.3")

	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
	testImplementation("io.mockk:mockk:1.13.12")
	testImplementation("io.kotest:kotest-runner-junit5:5.7.2")
	testImplementation("io.kotest:kotest-assertions-core:5.7.2")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
	kapt("jakarta.annotation:jakarta.annotation-api")
	kapt("jakarta.persistence:jakarta.persistence-api")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
//
//tasks.test {
//	outputs.dir(project.extra["snippetsDir"]!!)
//}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

idea {
	module {
		val kaptMain = file("build/generated/source/kapt/main")
		sourceDirs.add(kaptMain)
		generatedSourceDirs.add(kaptMain)
	}
}