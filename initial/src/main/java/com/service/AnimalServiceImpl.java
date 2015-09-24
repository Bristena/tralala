package com.service;

import com.dao.IAnimalDao;
import com.model.Animal;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bristena.vrancianu on 9/8/2015.
 */

public class AnimalServiceImpl implements IAnimalService {

    private IStapanSerivce stapanSerivce;
    private IAnimalDao animalDao;
    private final Logger logger = Logger.getLogger(AnimalServiceImpl.class);
    @Override
    public Animal getAnimalByDenumire(String denumire) {
        return animalDao.getAnimalByDenumire(denumire);
    }


    public void setAnimalDao(IAnimalDao animalDao) {

        this.animalDao = animalDao;
    }

    @Override
    public void setStapanService(IStapanSerivce stapanService) {
        this.stapanSerivce = stapanService;
    }


    private boolean isAnimalHomeless(Animal animal) {
        if (stapanSerivce.isStapanActive(animal.getIdStapan())) {
            updateHomelessAnimal(animal.getId(), false);
            return true;
        } else {
            updateHomelessAnimal(animal.getId(), true);
            return false;
        }
    }

    public List<Animal> createShelterAnimals() {
        List<Animal> animalList = getAnimals();
        List<Animal> homelessAnimalsList = new ArrayList<>();

        for (Animal animal : animalList) {
            if (isAnimalHomeless(animal))
                homelessAnimalsList.add(animal);
        }
        return homelessAnimalsList;
    }

    @Override
    public List<Animal> getAnimalsByIdStapan(int id) {
        return animalDao.getListAnimalsByIdStapan(id);
    }

    @Override
    public List<Animal> getDenumireAnimal(String nume) {
        return animalDao.getDenumireAnimal(nume);
    }

    @Override
    public List<Animal> getAnimals() {
        return animalDao.getAnimals();
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(int id) {
        logger.debug("deleting animal " + id);
        animalDao.delete(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(int id, String denumire, boolean homeless, int idStapan) {
        animalDao.update(id, denumire, homeless, idStapan);
    }

    @Override
    public Animal getAnimalById(int id) {
        return animalDao.getAnimalById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public Animal insert(Animal a) {
        return animalDao.insert(a);
    }

    @Override
    public void close() throws SQLException {
        animalDao.close();
    }

    @Override
    public void updateHomelessAnimal(int idAnimal, boolean isHomeless) {
        try {
            animalDao.updateHomelessAnimal(idAnimal, isHomeless);

        }
        catch (Exception ex){
            System.err.print(ex.fillInStackTrace());
        }

    }

    @Override
    public void insertBatchUpdate(List<Animal> list) {
        animalDao.insertBatchUpdate(list);
    }

}
