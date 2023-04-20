package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.XeDTO;

public class XeDAO {
	
	// 필드
	private SqlSessionFactory factory;
	
	// Singleton Patten
	private static XeDAO dao = new XeDAO();
	private XeDAO() {
		try {
			String resource = "config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static XeDAO getInstance() {
		return dao;
	}
	
	
	private final String NS = "repository.xe.";
	
	
	// 목록보기
	public List<XeDTO> list(){
		SqlSession ss = factory.openSession();
		List<XeDTO> result = ss.selectList(NS + "list");
		ss.close();
		return result;
	}
	
	// 상세보기
	public XeDTO detail(int xeNo) {
		SqlSession ss = factory.openSession();
		XeDTO result = ss.selectOne(NS + "detail", xeNo);
		ss.close();
		return result;
	}
	
	

}
