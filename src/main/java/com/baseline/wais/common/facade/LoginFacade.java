package com.baseline.wais.common.facade;

import com.baseline.wais.common.dto.request.LoginRequest;
import com.baseline.wais.common.dto.response.LoginResponse;

public interface LoginFacade {

	LoginResponse authenticateLogin(LoginRequest loginRequest);
}
