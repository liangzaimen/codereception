package top.hellooooo.codereceptionserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Q
 * @Date 18/09/2020 13:12
 * @Description
 */
@SpringBootApplication
@MapperScan("top.hellooooo.codereceptionserver.mapper")
public class CodeReceptionServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeReceptionServerApplication.class, args);
    }
}
