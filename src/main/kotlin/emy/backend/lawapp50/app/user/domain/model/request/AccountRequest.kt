package emy.backend.lawapp50.app.user.domain.model.request

import jakarta.validation.constraints.NotNull

data class AccountRequest(
    @NotNull
    val typeAccount : Long
)
