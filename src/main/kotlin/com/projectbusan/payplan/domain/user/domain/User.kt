package com.projectbusan.payplan.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User (
    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(
        nullable = false,
        unique = true)
    var username: String?,
    @Column(
        nullable = false,
        unique = true)
    var password: String?
) {
}