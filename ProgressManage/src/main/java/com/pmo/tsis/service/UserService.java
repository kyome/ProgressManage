package com.pmo.tsis.service;

import com.pmo.tsis.domain.UserVO;
import com.pmo.tsis.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
}
