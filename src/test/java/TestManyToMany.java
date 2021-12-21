import com.atguigu.springdata.bean.Role;
import com.atguigu.springdata.bean.User;
import com.atguigu.springdata.dao.RoleDao;
import com.atguigu.springdata.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Yurisman
 * @create 2021-02-2021/2/3-下午 01:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_config.xml")
public class TestManyToMany {
    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Test
    public void test01(){
        User user = new User("kobe", 24);
        Role r1 = new Role("scorer");
        Role r2 = new Role("passer");
        user.getRoles().add(r1);
        user.getRoles().add(r2);
        userDao.save(user);
        System.out.println("成功");
    }

    @Test
    public void test02(){
        Role role = new Role("bench");
        role.getUsers().add(new User("lbj",23));
        role.getUsers().add(new User("edwards",18));
        roleDao.save(role);
        System.out.println("成功");
    }

    @Test
    public void test03(){
        Role role = roleDao.findById(3).get();
        role.getUsers().forEach(System.out::println);
    }
}
