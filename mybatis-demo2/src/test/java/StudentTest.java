import com.hanxiao.bean.Student;
import com.hanxiao.mapper.StudentMapper;
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

public class StudentTest {
    static SqlSession sqlSession;
    static StudentMapper studentMapper;

    @BeforeClass
    public static void init() {
        sqlSession = MybatisUtils.getSqlSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
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
    public void testSelectStudentWithCourseList() {
        Student student = studentMapper.selectStudentWithCourseList(1);
        System.out.println("student = " + student);
    }

    @Test
    public void testSelectStudentWithCourseListUseCrossQuery() {
        Student student = studentMapper.selectStudentWithCourseListUseCrossQuery(1);
        System.out.println("student = " + student);
    }
}
