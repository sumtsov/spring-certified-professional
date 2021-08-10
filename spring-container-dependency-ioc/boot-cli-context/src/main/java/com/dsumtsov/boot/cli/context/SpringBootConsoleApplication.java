package com.dsumtsov.boot.cli.context;

import com.dsumtsov.boot.cli.context.beans.SpringBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private SpringBean1 springBean1;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        springBean1.test();
    }
}
