package comp.finalproject.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"comp.finalproject.user"})
@RestController
public class MarketplaceUser {

    public static void main(String[] args) {
        SpringApplication.run(MarketplaceUser.class, args);
    }

}
