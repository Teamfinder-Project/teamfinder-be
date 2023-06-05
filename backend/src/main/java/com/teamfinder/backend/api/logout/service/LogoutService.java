package com.teamfinder.backend.api.logout.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamfinder.backend.domain.member.entity.Member;
import com.teamfinder.backend.domain.member.service.MemberService;
import com.teamfinder.backend.global.error.ErrorCode;
import com.teamfinder.backend.global.error.exception.AuthenticationException;
import com.teamfinder.backend.global.jwt.constant.TokenType;
import com.teamfinder.backend.global.jwt.service.TokenManager;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LogoutService {

	private final MemberService memberService;
	private final TokenManager tokenManager;

	public void logout(String accessToken) {
		//토큰 검증
		tokenManager.validateToken(accessToken);

		//토큰 타입 확인
		Claims tokenClaims = tokenManager.getTokenClaims(accessToken);
		String tokenType = tokenClaims.getSubject();
		if (!TokenType.isAccessToken(tokenType)) {
			throw new AuthenticationException(ErrorCode.NOT_ACCESS_TOKEN_TYPE);
		}

		//refresh token 만료 처리
		Long memberId = Long.valueOf((Integer)tokenClaims.get("memberId"));
		Member member = memberService.findMemberByMemberId(memberId);
		member.expireRefreshToken(LocalDateTime.now());
	}
}
