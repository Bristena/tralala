//package com.test;
//
//import com.dao.AnimalDaoHibernateImpl;
//import com.dao.IAnimalDao;
//import com.model.Animal;
//import junit.framework.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
///**
// * Created by bristena.vrancianu on 9/16/2015.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"resources/../../../spring-config.xml"})
//@Transactional
//@TransactionConfiguration(defaultRollback=true)
//public class AnimalDaoHibernateImplTest {
//    @Autowired
//    IAnimalDao animalDaoHibernate;
//
//    @Test
//    public void testShouldGetAllAnimals(){
//        List<Animal> list = animalDaoHibernate.getAnimals();
//        assertNotNull(list);
//    }
//
//    @Test
//    public void testshouldInsertAnimal() {
//        Animal a = new Animal();
//        a.setDenumire("pisoias");
//        a.setIdStapan(3);
//        Animal insertedAnimal = animalDaoHibernate.insert(a);
//        assertNotNull(insertedAnimal);
//        assertEquals(insertedAnimal.getId(), a.getId());
//        assertEquals(insertedAnimal.getDenumire(), a.getDenumire());
//        assertEquals(insertedAnimal.getIdStapan(), a.getIdStapan());
//    }
//
//    @Test
//    public void testDeleteAnimal(){
//      animalDaoHibernate.delete(1);
//        Animal animalDeleted = animalDaoHibernate.getAnimalById(1);
//        assertNull(animalDeleted);
//
//    }
////    @Test
////    public void testShouldUpdateAnimal(){
////        Animal animal = animalDaoHibernate.getAnimalById(7);
////        animal.setDenumire("magar");
////        animalDaoHibernate.update(animal.getId(), animal.getDenumire());
////        Animal animalUpdated = animalDaoHibernate.getAnimalById(7);
////        assertEquals(animal.getDenumire(), animalUpdated.getDenumire());
////    }
//}