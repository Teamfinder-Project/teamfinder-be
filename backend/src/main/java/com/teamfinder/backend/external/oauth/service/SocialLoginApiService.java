package com.teamfinder.backend.external.oauth.service;

import com.teamfinder.backend.external.oauth.model.OAuthAttributes;

public interface SocialLoginApiService {

	OAuthAttributes getUserInfo(String accessToken);
}
