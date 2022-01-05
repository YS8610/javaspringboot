package sg.nus.nus.ws11;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ws11Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Ws11Application.class);
        
        String port = "8081";
        DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
        if (appArgs.containsOption("port")){
            port = appArgs.getOptionValues("port").get(0);
        }

        app.setDefaultProperties(Collections.singletonMap("server.port", port));

        System.out.println("App started on port " + port);
        app.run(args);
    }

}
