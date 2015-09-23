package com.hello;

import com.model.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bristena.vrancianu on 9/2/2015.
 */
public class RepositoryAnimal implements  IRepositoryAnimal {
    private List<Animal> list;
    public RepositoryAnimal (){
        list = new ArrayList<Animal>();
    }

    @Override
    public List<Animal> getAnimals() {

        Animal a1 = new Animal();
        a1.setId(1);
        a1.setDenumire("Caine");

        Animal a2 = new Animal();
        a2.setId(2);
        a2.setDenumire("Pisica");

        Animal a3 = new Animal();
        a3.setId(3);
        a3.setDenumire("Mamut");

        list.add(a1);
        list.add(a2);
        list.add(a3);
        return  list;
    }

    @Override
    public void delete(int id) {
        for(int i=0;i<list.size();i++) {
            if (list.get(i).getId() == id)

                list.remove(list.get(i));
        }
    }

    @Override
    public void update(int id,String denumire) {
        List<Animal> list = getAnimals();
        Animal a = getAnimalById(id);

        a.setDenumire(denumire);

    }

    @Override
    public Animal getAnimalById(int id) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId() == id)
                return list.get(i);
        }
        return null;
    }
    @Override
    public String getAnimalById1(int id) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId() == id)
                return list.get(i).getDenumire();
        }
        return null;
    }
    @Override
    public void insert(Animal a) {
        list.add(a);
    }

    public void insert(List<Animal> lista){
       // for()

    }
}
