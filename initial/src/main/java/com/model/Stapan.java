package com.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bristena.vrancianu on 9/11/2015.
 */

public class Stapan implements Serializable {
    private int id;
    private String nume;
    private String cnp;
    private boolean active;
    private Set<Animal> animals= new HashSet<Animal>();

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Stapan(){

    }
    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "Stapan{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", cnp='" + cnp + '\'' +
                '}';
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    public  Stapan(int id, Set<Animal> animals){
        this.id = id;
        this.animals = animals;
    }
}
