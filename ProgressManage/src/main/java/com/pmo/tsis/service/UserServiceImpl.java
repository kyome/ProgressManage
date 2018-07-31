package com.pmo.tsis.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pmo.tsis.domain.UserVO;
import com.pmo.tsis.dto.LoginDTO;
import com.pmo.tsis.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {

		return dao.login(dto);
	}

}
