import com.hanxiao.bean.Clazz;
import com.hanxiao.mapper.ClazzMapper;
import com.hanxiao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/28
 **/

public class ClazzTest {
    static SqlSession sqlSession;
    static ClazzMapper clazzMapper;

    @BeforeClass
    public static void init() {
        sqlSession = MybatisUtils.getSqlSession();
        clazzMapper = sqlSession.getMapper(ClazzMapper.class);
    }

    @After
    public void after() {
        sqlSession.commit();
    }

    @AfterClass
    public static void close() {
        sqlSession.close();
    }

    @Test
    public void testSelectClassWithStudentByIdUseCounts() {
        Clazz clazz = clazzMapper.selectClassWithStudentByIdUseCounts(1);
        System.out.println("clazz = " + clazz);
    }

    @Test
    public void testSelectClassWithStudentByIdUseCrossQuery() {
        Clazz clazz = clazzMapper.selectClassWithStudentByIdUseCrossQuery(1);
        System.out.println("clazz = " + clazz);
    }
}
