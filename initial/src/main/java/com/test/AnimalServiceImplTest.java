package com.test;

import com.dao.AnimalDaoHibernateImpl;
import com.dao.IAnimalDao;
import com.model.Animal;
import com.service.IAnimalService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by bristena.vrancianu on 9/16/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"resources/../../../spring-config.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class AnimalServiceImplTest {
    @Autowired
    IAnimalService animalService;
    @Before
    public void setUp() {

    }

    @Test
    public void testGetAllAnimals() {

        List<Animal> list = animalService.getAnimals();
        assertNotNull(list);

    }


    @Test
    public void testshouldInsertAnimal() {
        Animal a = new Animal();
        a.setDenumire("caracatita");
        a.setIdStapan(2);
        a.setHomeless(false);
        Animal insertedAnimal = animalService.insert(a);
        assertNotNull(insertedAnimal);
        assertEquals(insertedAnimal.getDenumire(), a.getDenumire());
        assertEquals(insertedAnimal.getIdStapan(), a.getIdStapan());
        assertEquals(insertedAnimal.isHomeless(), a.isHomeless());
    }

    @Test
    public void testDeleteAnimal(){
        animalService.delete(1);
        Animal animalDeleted = animalService.getAnimalById(1);
        assertNull(animalDeleted);

    }


}