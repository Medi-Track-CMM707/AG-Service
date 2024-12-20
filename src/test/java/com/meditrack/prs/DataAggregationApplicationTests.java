package com.meditrack.dataaggregation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DataAggregationApplication.class) // Provide the main class here
class DataAggregationApplicationTests {
    @Test
    void contextLoads() {
        // This test simply checks if the Spring context loads successfully.
        // If the context fails to load, this test will fail.
    }// ... rest of your test code
}
// package com.meditrack.dataaggregation; // Make sure this is the correct package for your tests

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest // This annotation is crucial for Spring Boot tests
// class DataAggregationApplicationTests {

//     @Test
//     void contextLoads() {
//         // This test simply checks if the Spring context loads successfully.
//         // If the context fails to load, this test will fail.
//     }
// }