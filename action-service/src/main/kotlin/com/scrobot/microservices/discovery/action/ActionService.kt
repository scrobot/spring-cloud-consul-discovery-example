package com.scrobot.microservices.discovery.action

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

interface ActionService {

    fun fire(): Mono<ActionDto>

}

@Service
@RefreshScope
open class ActionServer(
    private val eventClient: EventClient
): ActionService {

    @Value("\${actions.type}")
    private var actionType: String? = null

    override fun fire() = Mono.justOrEmpty(actionType)
        .flatMap { type ->
            when (type) {
                "network" -> eventClient.events().map { ActionDto(type, it) }
                else -> ActionDto(type, listOf()).toMono()
            }
        }

}