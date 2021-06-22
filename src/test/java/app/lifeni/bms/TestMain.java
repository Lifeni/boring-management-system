package app.lifeni.bms;

import app.lifeni.bms.mapper.FriendMapper;
import app.lifeni.bms.po.Friend;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMain {
    //会自动按照类型创建当前对象
    @Autowired
    private BasicDataSource dataSource;

    //测试数据库连接
    @Test
    public void testConnection() {
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //测试SqlSessionFactory
    @Autowired
    private SqlSessionFactory factory;

    @Test
    public void testSqlSession() {
        SqlSession sqlSession = factory.openSession();
        System.out.println(sqlSession);
    }

    //测试查询所有
    @Autowired
    private FriendMapper friendMapper;

    @Test
    public void testGetFriend() {
        List<Friend> friends = friendMapper.getFriend();
        for (Friend friend : friends) {
            System.out.println(friend);
        }
    }
}
