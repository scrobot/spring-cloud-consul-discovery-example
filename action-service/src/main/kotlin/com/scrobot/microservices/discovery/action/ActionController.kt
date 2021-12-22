package com.scrobot.microservices.discovery.action

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@RestController
class ActionController(
    private val eventClient: EventClient
) {

    @Value("\${actions.type}")
    private var actionType: String? = null

    @PostMapping("fire")
    fun test(): Mono<ActionDto> =  Mono.justOrEmpty(actionType)
        .flatMap { type ->
            when (type) {
                "network" -> eventClient.events().map { ActionDto(type, it) }
                else -> ActionDto(type, listOf()).toMono()
            }
        }

}