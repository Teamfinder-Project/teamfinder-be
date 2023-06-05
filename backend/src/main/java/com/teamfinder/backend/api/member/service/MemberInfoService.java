package com.teamfinder.backend.api.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamfinder.backend.api.member.dto.MemberInfoResponseDTO;
import com.teamfinder.backend.domain.member.entity.Member;
import com.teamfinder.backend.domain.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberInfoService {

	private final MemberService memberService;

	@Transactional(readOnly = true)
	public MemberInfoResponseDTO getMemberInfo(final Long memberId) {

		Member member = memberService.findMemberByMemberId(memberId);
		return MemberInfoResponseDTO.of(member);
	}
}
