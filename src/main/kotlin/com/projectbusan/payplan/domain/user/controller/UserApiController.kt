package com.projectbusan.payplan.domain.user.controller

import com.projectbusan.payplan.domain.user.controller.request.JoinRequest
import com.projectbusan.payplan.domain.user.controller.response.UserJoinResponse
import com.projectbusan.payplan.domain.user.service.CommandUserService
import com.projectbusan.payplan.domain.user.service.QueryUserService
import com.projectbusan.payplan.global.common.response.BasicResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserApiController (
    private val commandUserService: CommandUserService,
    private val queryUserService: QueryUserService
) {

    @PostMapping("/join")
    fun joinRequest(
        @RequestBody @Valid joinRequest: JoinRequest
    ): ResponseEntity<Map<String, Any>> {
        val userId = commandUserService.join(joinRequest)

        return BasicResponse.created(
            UserJoinResponse(userId))
    }
}