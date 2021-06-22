package app.lifeni.bms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("app.lifeni.bms.dao")
public class BoringManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoringManagementSystemApplication.class, args);
    }

}
