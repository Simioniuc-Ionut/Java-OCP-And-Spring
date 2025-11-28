package org.example.sq.part1.ch5;

import org.example.sq.part1.ch5.configuration.ProjectConfig;
import org.example.sq.part1.ch5.services.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Bcs of singleton, we refer to the same Repository Bean!
        var comm = context.getBean(CommentService.class);
        var user = context.getBean(UserService.class);
        System.out.println(comm.getCommentRepository()==user.getCommentRepository());

        // ----
        // Here we initialize in a lazy way.
        System.out.println("----------------");
        System.out.println("Before lazy!");
        var procLazy = context.getBean(ProcessLazyService.class);
        var processObj = context.getBean(ProcessObj.class);
        System.out.println("After lazy!");

        // ----
        // Here we show how prototype works.!
        System.out.println("----------------");
        var inst1 = context.getBean(ProcessStereotypeEagerService.class);
        var inst2 = context.getBean(ProcessStereotypeEagerService.class);
        System.out.println("Are equal ? " + (inst1 == inst2));
        System.out.println("----------------");

        // How to use a bean dependency with prototype inse in other bean ???
        // Answer is to inject the context!!
        var processServ = context.getBean(ProcessService.class);

        var proc1 = processServ.getAnProcessObj();
        var proc2 = processServ.getAnProcessObj();
        System.out.println("Produce a different processObj each time call the method." + '\n' + proc1 + " and " + proc2);

        // --- @LOKUP
        var proc3 = processServ.getObjWithLockUp();
        var proc4 = processServ.getObjWithLockUp();

        System.out.println("Produce different objs without injecting context: " + '\n' + proc3 + " and " + proc4);
    }
}
