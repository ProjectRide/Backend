package microservices.accountsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * Created by Sebastian on 10.11.16.
 */

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(AccountsWebApplication.class)
public class AccountsServer {

    //@Autowired
    //AccountRepository accountRepository;

    public static void main(String[] args) {
        // Will configure using accounts-server.yml
        System.setProperty("spring.config.name", "accounts-server");

        SpringApplication.run(AccountsServer.class, args);
    }
}
