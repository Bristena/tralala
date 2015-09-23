package com.dao;

import com.model.Animal;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bristena.vrancianu on 9/8/2015.
 */
public interface IAnimalDao {

    public List<Animal> getAnimals();
    public void delete(int id);
    public void update(int id, String denumire, boolean homeless, int idStapan);
    public Animal getAnimalById(int id);
    public Animal insert(Animal a);
    public void init() throws SQLException;
    public void close() throws  SQLException;
    public void insertBatchUpdate(List<Animal> list);
    public List<Animal> getListAnimalsByIdStapan(int id);
    public List<Animal> getDenumireAnimal(String nume);
    public Animal getAnimalByDenumire(String denumire);
    public void updateHomelessAnimal(int idAnimal, boolean homeless);
}
