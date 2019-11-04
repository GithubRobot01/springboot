package cn.itcast.service;

import cn.itcast.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void findById() {
        User user = userService.findById(8L);
        System.out.println("user:"+user);
    }

    @Test
    public void save() {
        User user=new User();
        user.setUserName("wqs");
        user.setName("wzy");
        user.setAge(23);

        userService.save(user);
    }
}