package emy.backend.lawapp50.exception

import java.time.LocalDateTime

data class ErrorResponseDto(
    val message : String,
    val detailMessage : String,
    val errorTime : LocalDateTime
)

data class ErrorResponseMessageDto(
    val message : String
)
