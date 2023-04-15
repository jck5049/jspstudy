package com.gdu.ex.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gdu.ex.domain.ExDto;

public class ExDao {
	
	// 필드
	private SqlSessionFactory factory;	// SqlSession을 만드는 공장
	
	// Singleton Pattern
	private static ExDao dao = new ExDao();
	private ExDao() {
		try {
			String resource = "com/gdu/ex/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static ExDao getInstance() {
		return dao;
	}
	
	// SqlSession이란?
	// MyBatis에서 사용하는 인터페이스
	// mapper에 있는 쿼리문을 읽어서 실행하는 객체 (ex.xml)파일을 읽어들인다는 말!
	
	// 메소드 1개가 쿼리문 1개를 실행한다.
	
	private final String NS = "com.gdu.ex.repository.ex.";	// mapper's namespace
	
	public List<ExDto> list(){
		SqlSession ss = factory.openSession();
		List<ExDto> result = ss.selectList(NS + "list");	// com.gdu.ex.repository.ex.list 와 같은 코드다.
		ss.close();	 // 사용한 자원 con, ps, rs 등 (DB는 항상 자원을 반납해줘야 하기 때문에 close() 필수이다!)
		return result;
		/*
		ss.selectList()	: SELECT 결과 행이 2개 이상일 때 사용한다.
		ss.selectOne()	: SELECT 결과 행이 1개일 때 사용한다.
		ss.insert()		: INSERT 실행할 때 사용한다.
		ss.update()		: UPDATE 실행할 때 사용한다.
		ss.delete()		: DELETE 실행할 때 사용한다.
		*/
		
	}
	
	public ExDto detail(int exNo) {
		SqlSession ss = factory.openSession();
		ExDto result = ss.selectOne(NS + "detail", exNo);	// exNo가 detail 쿼리로 전달되는 parameter이다.
		ss.close();
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
