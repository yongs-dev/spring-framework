package com.mark.springframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {}
record Address(String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Ethan";
    }

    @Bean
    public Integer age() {
        return 30;
    }

    @Bean
    @Primary
    public Person person() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person2() {
        return new Person("Henry", 32, address2());
    }

    @Bean
    public Person person3(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Person person4() {
        return new Person("Loopy", 32, address());
    }

    @Bean
    public Person person5(@Qualifier("address2Qualifier") Address address) {
        return new Person("Mary", 22, address);
    }

    @Bean
    @Primary
    public Address address() {
        return new Address("Chuncheon-si", "Kangwon-do");
    }


    @Bean(name = "address2")
    @Qualifier("address2Qualifier")
    public Address address2() {
        return new Address("Wonju-si", "Kangwon-do");
    }
}
