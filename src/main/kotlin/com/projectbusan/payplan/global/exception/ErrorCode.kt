package com.projectbusan.payplan.global.exception

import org.springframework.http.HttpStatus

enum class ErrorCode (
    val msg: String,
    val code: String,
    val statusCode: HttpStatus,
) {
    USER_CONFLICT("이미 존재하는 유저입니다.", "U409", HttpStatus.CONFLICT)
}