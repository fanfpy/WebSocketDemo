package top.fanfpy.websocketdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String passwd;
    private String header;
    private String createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", header='" + header + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
