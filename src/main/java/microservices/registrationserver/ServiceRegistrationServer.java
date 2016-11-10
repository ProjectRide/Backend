package microservices.registrationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Sebastian on 10.11.16.
 */

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistrationServer {

    public static void main(String[] args) {

        // Tell Boot to look for registration-server.yml, because of multiple springboot applications
        System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(ServiceRegistrationServer.class, args);
    }

}
