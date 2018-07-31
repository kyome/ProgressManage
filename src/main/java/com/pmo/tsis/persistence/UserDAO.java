package com.pmo.tsis.persistence;

import java.util.List;
import java.util.Map;

import com.pmo.tsis.domain.UserVO;
import com.pmo.tsis.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto)throws Exception;
	void insertMember(List<Map<String,String>> table);
}
