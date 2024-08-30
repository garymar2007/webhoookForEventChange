package com.gary.webhookForEventChange.model

data class WebhookEvent(
    val eventType: EventType,
    val data: Map<String, Any>,
    val timeStamp: Long
)

enum class EventType {
    USER_CREATED,
    USER_UPDATED,
    USER_DELETED,
    ORDER_PLACED
}
