package top.fanfpy.websocketdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Message {

    @Id
    //GeneratedValue(strategy = GenerationType.IDENTITY) 表示自增长方式使用mysql自带的
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer toUserId;


    private String text;
    private String createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreateDate() {
        System.out.println("33333333333");
        return createDate;
    }

    public void setCreateDate(String createDate) {
        if (createDate == null || createDate.equals("")){
            System.out.println("11111111111");
            this.createDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        }else {
            System.out.println("22222222222222");
            this.createDate = createDate;
        }
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", userId=" + userId +
                ", toUserId=" + toUserId +
                ", text='" + text + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
