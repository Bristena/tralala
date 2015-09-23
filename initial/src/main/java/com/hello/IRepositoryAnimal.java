package com.hello;

import com.model.Animal;

import java.util.List;

/**
 * Created by bristena.vrancianu on 9/2/2015.
 */
public interface IRepositoryAnimal {
    public List<Animal> getAnimals();
    public void delete(int id);
    public void update(int id, String denumire);
    public Animal getAnimalById(int id);
    public String getAnimalById1(int id);
    public void insert(Animal a);
}
