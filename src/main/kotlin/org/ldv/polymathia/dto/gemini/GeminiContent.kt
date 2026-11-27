package org.ldv.polymathia.dto.gemini

data class GeminiContent(
    val role: String,
    val parts: List<GeminiPart>
)