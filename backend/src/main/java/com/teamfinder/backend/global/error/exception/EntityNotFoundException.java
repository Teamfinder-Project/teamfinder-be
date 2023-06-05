package com.teamfinder.backend.global.error.exception;

import com.teamfinder.backend.global.error.ErrorCode;

public class EntityNotFoundException extends BusinessException {

	public EntityNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}
}
