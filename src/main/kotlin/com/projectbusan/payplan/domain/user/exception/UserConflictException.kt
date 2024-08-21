package com.projectbusan.payplan.domain.user.exception

import com.projectbusan.payplan.global.exception.BasicException
import com.projectbusan.payplan.global.exception.ErrorCode

class UserConflictException : BasicException(ErrorCode.USER_CONFLICT) {

}
