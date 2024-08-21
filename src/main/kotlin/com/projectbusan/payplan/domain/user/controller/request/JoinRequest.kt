package com.projectbusan.payplan.domain.user.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class JoinRequest (
    @field: NotEmpty(message = "닉네임이 없습니다.")
    @field: Size(min = 2, max = 10, message = "닉네임은 최소 2자에서 최대 10자 내여야 합니다.")
    val username: String?,

    @field: Email(message = "이메일 형식이 아닙니다.")
    @field: NotEmpty(message = "이메일이 없습니다.")
    val email: String?,

    @field: NotEmpty(message = "비밀번호가 없습니다.")
    @field: Size(min = 8, message = "비밀번호는 최소 8자를 넘겨야 합니다.")
    val rawPassword: String?
) {
}
