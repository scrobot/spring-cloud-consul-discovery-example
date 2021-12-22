package com.scrobot.microservices.discovery.event

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

@RestController
class EventController {

    @GetMapping("events")
    fun events(): Mono<List<Event>> = Flux.fromIterable(0..5)
        .map { Event(UUID.randomUUID(), "event #$it") }
        .collectList()

}