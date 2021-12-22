package com.scrobot.microservices.discovery.event

import java.util.UUID

data class Event(
    val id: UUID,
    val name: String
)
