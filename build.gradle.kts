import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

extra["springCloudVersion"] = "2021.0.0"

allprojects {
	repositories {
		mavenCentral()
	}

	group = "com.scrobot.microservices"
}

subprojects {

	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "kotlin")

	repositories {
		mavenCentral()
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		}
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

}


