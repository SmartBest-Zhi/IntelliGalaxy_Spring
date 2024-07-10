package cn.yczbest.usercenterserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.yczbest.usercenterserver")
public class UserCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterServerApplication.class, args);
    }

}
