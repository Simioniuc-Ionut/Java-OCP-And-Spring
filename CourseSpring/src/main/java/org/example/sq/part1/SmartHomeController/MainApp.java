package org.example.sq.part1.SmartHomeController;


import org.example.sq.part1.SmartHomeController.services.lightning.LightControlServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class,args);

        LightControlServiceImpl service1 = context.getBean(LightControlServiceImpl.class);
        LightControlServiceImpl service2 = context.getBean(LightControlServiceImpl.class);
        System.out.println("Are beans equals ? " + (service1==service2) + '\n'  + service1 +" - " + service2);
    }
}
