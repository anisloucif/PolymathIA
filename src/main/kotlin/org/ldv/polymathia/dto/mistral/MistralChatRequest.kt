package org.ldv.polymathia.dto.mistral

data class MistralChatRequest(
    val model: String,
    val messages: List<MistralMessage>
)