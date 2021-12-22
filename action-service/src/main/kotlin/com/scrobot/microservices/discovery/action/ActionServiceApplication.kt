package com.scrobot.microservices.discovery.action

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import reactivefeign.spring.config.EnableReactiveFeignClients

@SpringBootApplication
@EnableReactiveFeignClients(
	clients = [EventClient::class]
)
open class ActionServiceApplication

fun main(args: Array<String>) {
	runApplication<ActionServiceApplication>(*args)
}
