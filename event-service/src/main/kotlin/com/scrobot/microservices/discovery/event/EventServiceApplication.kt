package com.scrobot.microservices.discovery.event

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class EventServiceApplication

fun main(args: Array<String>) {
	runApplication<EventServiceApplication>(*args)
}
