package com.scrobot.microservices.discovery.action

data class ActionDto(
    val type: String,
    val events: List<EventDto>
)