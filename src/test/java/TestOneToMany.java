import com.atguigu.springdata.bean.ContactPerson;
import com.atguigu.springdata.bean.Customer;
import com.atguigu.springdata.dao.ContactPersonDao;
import com.atguigu.springdata.dao.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @author Yurisman
 * @create 2021-02-2021/2/3-上午 11:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_config.xml")
public class TestOneToMany {
    @Autowired
    CustomerDao customerDao;
    @Autowired
    ContactPersonDao contactPersonDao;

    @Test
    public void test01(){
        Customer customer = customerDao.findById(2).get();
        Set<ContactPerson> persons = customer.getContactPersons();
        persons.forEach(System.out::println);
    }

    @Test
    public void test02(){
        ContactPerson person = contactPersonDao.findById(3).get();
        Customer customer = person.getCustomer();
        System.out.println(customer);
    }

    /**
     * 級聯新增
     */
    @Test
    public void test04(){
        ContactPerson person = new ContactPerson("test2", "女", "8888", "none", "abc@gmail.com", "0", "none");
        Customer customer = new Customer("beal", "0", "python", "1", "tainan", "7736");
//        customer.getContactPersons().add(person);
        person.setCustomer(customer);
//        customerDao.save(customer);
        contactPersonDao.save(person);
        System.out.println("完成");
    }

    @Test
    public void test05(){
        Customer customer = customerDao.findById(1).get();
        customer.getContactPersons().forEach(System.out::println);
    }
}
