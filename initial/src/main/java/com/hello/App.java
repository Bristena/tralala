//package com.hello;
//
//import com.dao.DAO;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by bristena.vrancianu on 9/8/2015.
// */
//public class App {
//    public static void main(String[] args) throws SQLException {
//
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        DAO com.dao = (DAO) context.getBean("com.dao");
//        com.dao.open();
//        Animal a = new Animal();
//        a.setDenumire("lup");
//      // com.dao.delete(9);
//     //   com.dao.insert(a);
//        Animal an = com.dao.getAnimalById(4);
//        com.dao.update(3, "updateTest");
//        System.out.print(an.toString());
//
//        List<Animal> listToAdd = new ArrayList<Animal>();
//        Animal a1 = new Animal();
//        a1.setId(1);
//        a1.setDenumire("CaineB");
//
//        Animal a2 = new Animal();
//        a2.setId(2);
//        a2.setDenumire("PisicaB");
//
//        Animal a3 = new Animal();
//        a3.setId(3);
//        a3.setDenumire("MamutB");
//
//        listToAdd.add(a1);
//        listToAdd.add(a2);
//        listToAdd.add(a3);
//        com.dao.insertBatchUpdate(listToAdd);
//        List<Animal> list = com.dao.getAnimals();
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i).toString());
//        }
//        com.dao.close();
//        context.close();
//    }
//}
