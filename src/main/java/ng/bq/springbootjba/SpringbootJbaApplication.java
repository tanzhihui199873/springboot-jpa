package ng.bq.springbootjba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"ng.bq.springbootjba.dao"})
public class SpringbootJbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJbaApplication.class, args);
    }

}
