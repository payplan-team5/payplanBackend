package com.projectbusan.payplan.global.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueryDslConfig (
    private val em: EntityManager
) {

    @get:Bean
    val query = JPAQueryFactory(em)
}