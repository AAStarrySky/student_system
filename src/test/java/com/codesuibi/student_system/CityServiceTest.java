package com.codesuibi.student_system;

import com.codesuibi.entity.City;
import com.codesuibi.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    void findAllTest() {
        List<City> all = cityService.findAll();
        all.forEach(city -> {
            System.out.println("city" + city);
        });
    }
}
