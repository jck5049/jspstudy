package repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.StuDTO;

public class StuDAO {

    SqlSessionFactory factory;

    private static StuDAO dao = new StuDAO();

    public static StuDAO getInstance() {
        return dao;
    }

    private StuDAO() {
        try {
            String resource = "mybatis/config/mybatis-config.xml";
            InputStream in = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final String NS = "mybatis.mapper.stu.";

    public List<StuDTO> getStuList() {
        SqlSession ss = factory.openSession();
        List<StuDTO> studentList = ss.selectList(NS + "getStuList");
        ss.close();
        return studentList;
    }

}