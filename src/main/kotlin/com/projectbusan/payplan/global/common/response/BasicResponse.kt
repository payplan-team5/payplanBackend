package com.projectbusan.payplan.global.common.response

import com.projectbusan.payplan.global.exception.ErrorCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class BasicResponse {
    companion object {
        fun error(errorCode: ErrorCode) =
            ErrorResponse(errorCode)
                .toResponseEntity()

        fun ok(data: Any) =
            SuccessResponse(data)
                .toResponseEntity()

        fun ok(message: String) =
            SuccessResponse(message)
                .toResponseEntity()

        fun created(data: Any) =
            SuccessResponse(data)
                .toResponseEntity(HttpStatus.CREATED)

        fun created(msg: String) =
            SuccessResponse(msg)
                .toResponseEntity(HttpStatus.CREATED)
    }

    class SuccessResponse (
        private val data: Any,
    ) {
        fun toResponseEntity(
            statusCode: HttpStatus = HttpStatus.OK
        ) =
            ResponseEntity.status(statusCode)
                .body(
                    mapOf(
                        "data" to data,
                        "status" to BasicStatus.SUCCESS
                    ))
    }

    class ErrorResponse (
        private val errorCode: ErrorCode,
    ) {
        fun toResponseEntity() =
            ResponseEntity.status(errorCode.statusCode)
                .body(mapOf (
                    "data" to mapOf(
                        "message" to errorCode.msg,
                        "code" to errorCode.code
                    ),
                    "status" to BasicStatus.ERROR
                ))
    }
}

private enum class BasicStatus {
    SUCCESS, ERROR
}