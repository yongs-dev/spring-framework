package com.mark.springframework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan
public class DILauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DILauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessClass.class));
        }
    }
}

@Component
class BusinessClass {

    Dependency1 dependency1;

    Dependency2 dependency2;

    public BusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection - setDependency1 ");
        this.dependency1 = dependency1;
    }

    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection - setDependency2 ");
        this.dependency2 = dependency2;
    }

    @Override
    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}