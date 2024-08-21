package com.projectbusan.payplan.global.annotation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Transactional(readOnly = true)
@Service
annotation class QueryService