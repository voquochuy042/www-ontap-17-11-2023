package com.se.fit;

import com.se.fit.models.Product;
import com.se.fit.repositories.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ontap1711Application {

    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(Ontap1711Application.class, args);
    }
//    Create fake data
//    @Bean
//    CommandLineRunner commandLineRunner (){
//        Faker faker = new Faker();
//        return args -> {
//            for(int i = 0;i<10;i++){
//                Product product = Product.builder()
//                        .name(faker.commerce().productName())
//                        .price(Double.parseDouble(faker.commerce().price()))
//                        .build();
//                productRepository.save(product);
//            }
//        };
//    }

}
