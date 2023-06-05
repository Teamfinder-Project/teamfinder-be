package com.teamfinder.backend.global.error.exception;

import com.teamfinder.backend.global.error.ErrorCode;

public class AuthenticationException extends BusinessException {

	public AuthenticationException(ErrorCode errorCode) {
		super(errorCode);
	}
}
