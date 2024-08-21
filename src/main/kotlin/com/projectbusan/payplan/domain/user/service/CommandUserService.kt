package com.projectbusan.payplan.domain.user.service

import com.projectbusan.payplan.domain.user.controller.request.JoinRequest
import com.projectbusan.payplan.domain.user.domain.User
import com.projectbusan.payplan.domain.user.exception.UserConflictException
import com.projectbusan.payplan.domain.user.persistence.UserRepository
import com.projectbusan.payplan.global.annotation.CommandService
import org.springframework.security.crypto.password.PasswordEncoder

@CommandService
class CommandUserService (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun join(joinRequest: JoinRequest): Long {
        if (userRepository.existByUsername(joinRequest.username!!))
            throw UserConflictException()

        return userRepository.save(User(
            id = null,
            username = joinRequest.username,
            password = passwordEncoder.encode(
                joinRequest.rawPassword
            )
        )).id!!
    }
}