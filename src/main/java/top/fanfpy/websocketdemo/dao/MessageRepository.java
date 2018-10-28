package top.fanfpy.websocketdemo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import top.fanfpy.websocketdemo.entity.Message;
import java.util.ArrayList;

public interface MessageRepository extends JpaRepository<Message , Integer> {

    ArrayList<Message> findByUserIdOrToUserId(Integer id);

    ArrayList<Message> findByUserIdAndToUserId(Integer userId , Integer toUserId);
}
