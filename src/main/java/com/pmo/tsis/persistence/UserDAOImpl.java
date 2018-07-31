package com.pmo.tsis.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmo.tsis.domain.UserVO;
import com.pmo.tsis.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.pmo.tsis.mapper.UserMapper";
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".login", dto);
	}

	@Override
	public void insertMember(List<Map<String, String>> table) {
		for ( int i = 0 ; i < table.size(); i ++){
			session.insert(namespace+".memberInsert", table.get(i));
		}
		
	}
}
