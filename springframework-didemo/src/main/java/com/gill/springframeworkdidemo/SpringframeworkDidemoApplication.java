package com.gill.springframeworkdidemo;

import com.gill.springframeworkdidemo.controller.ConstructorInjectedController;
import com.gill.springframeworkdidemo.controller.GetterInjectedController;
import com.gill.springframeworkdidemo.controller.MyController;
import com.gill.springframeworkdidemo.controller.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringframeworkDidemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringframeworkDidemoApplication.class, args);
        ApplicationContext ctx = SpringApplication.run(SpringframeworkDidemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        //controller.hello();
        System.out.println(controller.hello());
        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
    }

}
