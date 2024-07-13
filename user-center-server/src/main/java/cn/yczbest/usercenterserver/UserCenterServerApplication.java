package cn.yczbest.usercenterserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterServerApplication.class, args);
    }

}
