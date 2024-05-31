package co.essejacques.servereureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerEurekaApplication {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(ServerEurekaApplication.class, args);
    }
}
