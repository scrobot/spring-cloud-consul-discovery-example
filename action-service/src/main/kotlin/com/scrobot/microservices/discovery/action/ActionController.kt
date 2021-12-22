package com.scrobot.microservices.discovery.action

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ActionController(
    private val actionService: ActionService
) {

    @PostMapping("fire")
    fun test(): Mono<ActionDto> = actionService.fire()

}