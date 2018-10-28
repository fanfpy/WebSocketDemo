package top.fanfpy.websocketdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanfpy.websocketdemo.dao.UserRepository;
import top.fanfpy.websocketdemo.entity.User;
import top.fanfpy.websocketdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean login(User user) {
        return userRepository.findByNameAndPasswd(user.getName(),user.getPasswd());
    }
}
