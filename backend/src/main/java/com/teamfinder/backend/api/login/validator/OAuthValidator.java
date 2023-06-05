package com.teamfinder.backend.api.login.validator;

import org.springframework.stereotype.Service;

import com.teamfinder.backend.global.error.ErrorCode;
import com.teamfinder.backend.global.error.exception.BusinessException;
import com.teamfinder.backend.domain.member.constant.MemberType;

@Service
public class OAuthValidator {


	public void validateMemberType(String memberType) {
		if (!MemberType.isMemberType(memberType)) {
			throw new BusinessException(ErrorCode.INVALID_MEMBER_TYPE);
		}
	}
}
