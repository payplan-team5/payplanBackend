package com.projectbusan.payplan.global.exception

import org.springframework.http.HttpStatus

enum class ErrorCode (
    val msg: String,
    val statusCode: HttpStatus,
    val code: String
) {
}