package top.fanfpy.websocketdemo.service;

import top.fanfpy.websocketdemo.entity.User;

public interface UserService {
    public User addUser(User user);
    public Boolean login(User user);
}
