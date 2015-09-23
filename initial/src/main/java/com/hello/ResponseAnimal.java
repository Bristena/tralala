package com.hello;

import com.model.Animal;

/**
 * Created by bristena.vrancianu on 9/2/2015.
 */
public class ResponseAnimal {
    private IRepositoryAnimal repo;
    public ResponseAnimal(){
        repo = new RepositoryAnimal();    }

    public  void verifyDuplicate(Animal a){
        if(a.equals(repo.getAnimalById(a.getId()))){

        }
    }
}
