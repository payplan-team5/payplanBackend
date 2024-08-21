package com.projectbusan.payplan.domain.user.persistence

import com.projectbusan.payplan.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun existByUsername(username: String): Boolean
}