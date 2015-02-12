package com.makotan.tools;

import com.makotan.tools.service.CliBootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private CliBootService cliBootService;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        cliBootService.start(args);
    }
}
