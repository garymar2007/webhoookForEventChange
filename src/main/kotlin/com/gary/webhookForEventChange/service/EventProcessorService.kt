package com.gary.webhookForEventChange.service

import com.gary.webhookForEventChange.model.EventType
import com.gary.webhookForEventChange.model.WebhookEvent
import org.springframework.stereotype.Service

@Service
class EventProcessorService {
    fun processEvent(event: WebhookEvent) {
        when(event.eventType) {
            EventType.USER_CREATED -> handleUserCreatedEvent(event.data)
            EventType.USER_UPDATED -> handleUserUpdatedEvent(event.data)
            EventType.USER_DELETED -> handleUserDeletedEvent(event.data)
            EventType.ORDER_PLACED -> handleOrderPlacedEvent(event.data)
            else -> throw IllegalArgumentException("Invalid event type: ${event.eventType}")
        }
    }

    private fun handleUserCreatedEvent(data: Map<String, Any>) {
        println("User created: $data")
    }

    private fun handleUserUpdatedEvent(data: Map<String, Any>) {
        println("User updated: $data")
    }

    private fun handleUserDeletedEvent(data: Map<String, Any>) {
        println("User deleted: $data")
    }

    private fun handleOrderPlacedEvent(data: Map<String, Any>) {
        println("Order placed: $data")
    }

}