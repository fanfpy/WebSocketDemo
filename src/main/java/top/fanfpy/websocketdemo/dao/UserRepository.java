package top.fanfpy.websocketdemo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.websocketdemo.entity.User;

public interface UserRepository extends JpaRepository<User , Integer> {
    Boolean findByNameAndPasswd(String name , String passwd);
}
