package top.fanfpy.websocketdemo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.fanfpy.websocketdemo.entity.User;
import top.fanfpy.websocketdemo.service.UserService;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setName("郑年年");
        user.setPasswd("1234");

        System.out.println(userService.addUser(user));
    }

    @Test
    public void login() {
    }
}