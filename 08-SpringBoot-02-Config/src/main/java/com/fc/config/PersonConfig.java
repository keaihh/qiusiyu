package com.fc.config;

import com.fc.entity.Person;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(Person.class)
public class PersonConfig {

    @RequestMapping("person")
    public Person person() {
        return new Person();
    }
}
