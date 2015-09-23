package com.test;

import com.dao.AnimalDaoImpl;
import com.dao.IAnimalDao;
import com.model.Animal;
import com.model.Stapan;
import com.service.IAnimalService;
import com.service.IStapanSerivce;
import com.service.StapanServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by bristena.vrancianu on 9/21/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"resources/../../../spring-config.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AnimalServiceTest {

    @Autowired
    public IAnimalService animalService;


    @Test
    public void testCreateShelterAnimals() {

        IAnimalDao animalDao = mock(AnimalDaoImpl.class);
        IStapanSerivce stapanService = mock(StapanServiceImpl.class);
        animalService.setAnimalDao(animalDao);
        animalService.setStapanService(stapanService);
        int idStapan = 3;
        when(stapanService.isStapanActive(idStapan)).thenReturn(true);
        List<Animal> list = new ArrayList<>();
        Animal animalHomeless = new Animal();
        animalHomeless.setHomeless(false);
        animalHomeless.setDenumire("motan");
        animalHomeless.setIdStapan(idStapan);
        animalHomeless.setId(1);
        list.add(animalHomeless);
        when(animalDao.getAnimals()).thenReturn(list);
        List<Animal> homelessAnimals = animalService.createShelterAnimals();
        assertEquals(1, homelessAnimals.size());

    }

    @Test
    public  void testCreateShelterAnimalsStapanNotActiveAnimalNotHomeless(){

        IAnimalDao animalDao = mock(AnimalDaoImpl.class);
        IStapanSerivce stapanService = mock(StapanServiceImpl.class);
        animalService.setAnimalDao(animalDao);
        animalService.setStapanService(stapanService);
        int idStapan = 3;
        when(stapanService.isStapanActive(idStapan)).thenReturn(false);
        List<Animal> list = new ArrayList<>();
        Animal animalHomeless = new Animal();
        animalHomeless.setHomeless(false);
        animalHomeless.setDenumire("motan");
        animalHomeless.setIdStapan(idStapan);
        animalHomeless.setId(1);
        list.add(animalHomeless);
        when(animalDao.getAnimals()).thenReturn(list);
        List<Animal> homelessAnimals = animalService.createShelterAnimals();
        assertEquals(0, homelessAnimals.size());
    }

    @Test
    public void testCreateShelterAnimalesStapanActivAnimalHomeless(){
        IAnimalDao animalDao = mock(AnimalDaoImpl.class);
        IStapanSerivce stapanService = mock(StapanServiceImpl.class);
        animalService.setAnimalDao(animalDao);
        animalService.setStapanService(stapanService);
        int idStapan = 3;
        when(stapanService.isStapanActive(idStapan)).thenReturn(true);
        List<Animal> list = new ArrayList<>();
        Animal animalHomeless = new Animal();
        animalHomeless.setHomeless(true);
        animalHomeless.setDenumire("motan");
        animalHomeless.setIdStapan(idStapan);
        animalHomeless.setId(1);
        list.add(animalHomeless);
        when(animalDao.getAnimals()).thenReturn(list);
        List<Animal> homelessAnimals = animalService.createShelterAnimals();
        assertEquals(1, homelessAnimals.size());
    }
    @Test
    public void testCreateShelterAnimalesStapanNotActivAnimalHomeless(){
        IAnimalDao animalDao = mock(AnimalDaoImpl.class);
        IStapanSerivce stapanService = mock(StapanServiceImpl.class);
        animalService.setAnimalDao(animalDao);
        animalService.setStapanService(stapanService);
        int idStapan = 3;
        when(stapanService.isStapanActive(idStapan)).thenReturn(false);
        List<Animal> list = new ArrayList<>();
        Animal animalHomeless = new Animal();
        animalHomeless.setHomeless(true);
        animalHomeless.setDenumire("motan");
        animalHomeless.setIdStapan(idStapan);
        animalHomeless.setId(1);
        list.add(animalHomeless);
        when(animalDao.getAnimals()).thenReturn(list);
        List<Animal> homelessAnimals = animalService.createShelterAnimals();
        assertEquals(0, homelessAnimals.size());
    }
}
