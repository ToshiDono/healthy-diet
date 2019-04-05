package com.fls.healthydiet;

import com.fls.healthydiet.model.Allergy;
import com.fls.healthydiet.model.Product;
import com.fls.healthydiet.repository.AllergyRepository;
import com.fls.healthydiet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthyDietApplication implements CommandLineRunner {

    @Autowired
    AllergyRepository allergyRepository;

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(HealthyDietApplication.class, args);
    }

    @Override
    public void run(String... args) {
        allergyRepository.deleteAllInBatch();
        productRepository.deleteAllInBatch();

        Allergy allergy = new Allergy("allergy 1");

        Product product1 = new Product("first product");
        Product product2 = new Product("second product");

        allergy.getProducts().add(product1);
        allergy.getProducts().add(product2);

        product1.getAllergies().add(allergy);
        product2.getAllergies().add(allergy);

        allergyRepository.save(allergy);
        productRepository.save(product1);
        productRepository.save(product2);


        // Create a couple of Book and Publisher
//        allergyRepository.save(new Allergy("Allergy 1", new Product("Product", "descr 1"), new Product("Product 2", "descr 2")));
    }

}
