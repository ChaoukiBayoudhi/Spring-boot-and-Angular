package com.isg.soa.tps.toyesmarket.server;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

//    @Bean
//    ApplicationRunner init(toyRepository repository){

//        return args -> {
//            Stream.of(
//                    new Toy("Car Toy", "Electronic", 3, 9, 15d),
//                    new Toy("Doll Toy", "other", 3, 9, 20d),
//                    new Toy("Moto", "Electronic", 3, 9, 20d),
//                    new Toy("Chess", "Brain", 7, 17, 25d),
//                    new Toy("Ball", "Sport", 7, 17, 25d),
//                    new Toy("Guitar", "Electronic", 7, 17, 25d),
//                    new Toy("Plane", "Electronic", 7, 17, 25d)
//            ).forEach(repository::save);
//            repository.findAll().forEach(System.out::println);
//        };
//    }

//    @Bean
//    ApplicationRunner showAll(toyRepository repository){
//        return args -> {
//            repository.findAll().forEach(System.out::println);
//        };
//    }
}
