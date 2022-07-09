package com.swu.foodka;

import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxiaolin
 */
@Slf4j
@SpringBootApplication
public class FoodKaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodKaApplication.class, args);
        log.info("FOODKA!KA!KA!");
    }

}
