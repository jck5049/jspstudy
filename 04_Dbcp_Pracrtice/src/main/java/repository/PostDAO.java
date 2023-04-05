package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import domain.PostVO;

public class PostDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private DataSource dataSource;
	
	private static PostDAO dao = new PostDAO();
	private PostDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");	// context.xml 에 있는 코드를 불러서 그 양식에 맞게 사용할 수 있도록 호출하는 코드
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static PostDAO getInstance() {
		return dao;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 목록 보기
	public List<PostVO> getAllPosts() throws Exception {
		List<PostVO> posts = new ArrayList<PostVO>();
		con = dataSource.getConnection();
		sql = "SELECT POST_NO, WRITER, TITLE, CONTENT, IP, MODIFIED_DATE, CREATED_DATE";	// 이결과 전체를 rs로 볼수있다.
		sql += "  FROM POST";
		sql += " ORDER BY POST_NO DESC";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			PostVO post = PostVO.builder()		// 이 코드를 사용하려면 PostVO에 @Builder가 추가가 되어있어야 한다.
							.post_no(rs.getInt(1))		// setPost_no(rs.getInt(1))과 같은 역할이다.
							.writer(rs.getString(2))
							.title(rs.getString(3))
							.content(rs.getString(4))
							.ip(rs.getString(5))
							.modified_date(rs.getDate(6))
							.created_date(rs.getDate(7))
							.build();
			posts.add(post);
		}
		close();
		return posts;
	}
	
	// 삽입 하기
	public int savePost(PostVO post) throws Exception {
		con = dataSource.getConnection();
		sql = "INSERT INTO POST(POST_NO, WRITER, TITLE, CONTENT, IP, MODIFIED_DATE, CREATED_DATE)";
		sql += " values(POST_SEQ.NEXTVAL, ?, ?, ?, ?, NULL, SYSDATE)";
		ps = con.prepareStatement(sql);
		ps.setString(1, post.getWriter());
		ps.setString(2, post.getTitle());
		ps.setString(3, post.getContent());
		ps.setString(4, post.getIp());
		int saveResult = ps.executeUpdate();
		close();
		return saveResult;
	}
	
	public PostVO getPostByNo(int post_no) throws Exception {
		PostVO post = null;
		con = dataSource.getConnection();
		sql = "SELECT POST_NO, WRITER, TITLE, CONTENT, IP, MODIFIED_DATE, CREATED_DATE";
		sql += " FROM POST";
		sql += " WHERE POST_NO = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, post_no);
		rs = ps.executeQuery();
		if(rs.next()) {
			post = PostVO.builder()
					.post_no(post_no)
					.writer(rs.getString(2))
					.title(rs.getString(3))
					.content(rs.getString(4))
					.ip(rs.getString(5))
					.modified_date(rs.getDate(6))
					.created_date(rs.getDate(7))
					.build();
		}
		close();
		return post;
	}
	
	public int updatePost(PostVO post) throws Exception {
		con = dataSource.getConnection();
		sql  = "UPDATE POST";
		sql += " SET TITLE = ?, CONTENT = ?, MODIFIED_DATE = SYSDATE";
		sql += " WHERE POST_NO = ?";
		ps.setString(1, post.getTitle());
		ps.setString(2, post.getContent());
		ps.setInt(3, post.getPost_no());
		int updateResult = ps.executeUpdate();
		close();
		return updateResult;
	}
	
	public int deletePost(int post_no) throws Exception {
		con = dataSource.getConnection();
		sql = "DELETE FROM POST WHERE POST_NO = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, post_no);
		int deleteResult = ps.executeUpdate();
		close();
		return deleteResult;
	}
	
	
	

}
