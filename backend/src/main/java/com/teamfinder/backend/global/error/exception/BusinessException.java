package com.teamfinder.backend.global.error.exception;

import com.teamfinder.backend.global.error.ErrorCode;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

	private ErrorCode errorCode;

	public BusinessException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}
