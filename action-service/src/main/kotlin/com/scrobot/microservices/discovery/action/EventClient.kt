package com.scrobot.microservices.discovery.action

import org.springframework.web.bind.annotation.GetMapping
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Mono

@ReactiveFeignClient(name = "event-service")
interface EventClient {

    @GetMapping("events")
    fun events(): Mono<List<EventDto>>

}