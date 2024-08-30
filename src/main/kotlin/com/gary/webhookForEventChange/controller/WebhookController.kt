package com.gary.webhookForEventChange.controller

import com.gary.webhookForEventChange.model.WebhookEvent
import com.gary.webhookForEventChange.service.EventProcessorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebhookController(
    private val eventProcessorService: EventProcessorService
) {
    @PostMapping("/webhook")
    fun handleWebhook(@RequestBody event: WebhookEvent): ResponseEntity<String> {
        return try{
            eventProcessorService.processEvent(event)
            ResponseEntity("Event processed successfully", HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity("Error processing event: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}