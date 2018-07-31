package com.pmo.tsis.persistence;

import com.pmo.tsis.domain.UserVO;
import com.pmo.tsis.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto)throws Exception;
}
