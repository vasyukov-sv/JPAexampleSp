package ru.javastudy.app;


import org.springframework.context.support.GenericXmlApplicationContext;
import ru.javastudy.entities.ContactEntity;
import ru.javastudy.intf.ContactService;

import java.util.List;

class Main {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml"); //move from src.main.java to src.main.resources
        ctx.refresh();

        ContactService service = ctx.getBean("jpaContactService", ContactService.class);
        List<ContactEntity> contacts = service.findAll();
        printAll(contacts);

        contacts = service.findByFirstName("Name1");
        printAll(contacts);

        contacts = service.findByFirstNameAndLastName("Name2", "LastName2");
        printAll(contacts);

        System.out.println("Who loves Football:");
        System.out.println(service.contactsByHobby("Football"));
//        printAll(contacts2);
    }

    private static void printAll(List<ContactEntity> contacts) {
        System.out.println("printAll: ");
        for (ContactEntity contact : contacts) {
            System.out.println(contact);
        }
        System.out.println();
    }
}
