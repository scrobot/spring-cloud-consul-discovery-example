group = "com.scrobot.microservices.actions"
version = "0.0.1-SNAPSHOT"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.springframework.cloud:spring-cloud-starter-consul-config")
    implementation("org.springframework.cloud:spring-cloud-starter-consul-discovery")
    implementation("com.playtika.reactivefeign:feign-reactor-cloud:3.1.5")
    implementation("com.playtika.reactivefeign:feign-reactor-spring-cloud-starter:3.1.5")

    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}