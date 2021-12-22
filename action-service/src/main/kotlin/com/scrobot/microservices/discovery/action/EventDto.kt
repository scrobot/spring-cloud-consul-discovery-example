package com.scrobot.microservices.discovery.action

import java.util.UUID

data class EventDto(
    val id: UUID,
    val name: String
)
