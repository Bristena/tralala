package com.model;

import java.io.Serializable;

/**
 * Created by bristena.vrancianu on 9/2/2015.
 */

public class Animal implements Serializable {
    private String denumire;
    private int id;
    private int idStapan;
    private boolean homeless;

    public boolean isHomeless() {
        return homeless;
    }

    public void setHomeless(boolean homeless) {
        this.homeless = homeless;
    }

    public int getIdStapan() {
        return idStapan;
    }

    public void setIdStapan(int idStapan) {
        this.idStapan = idStapan;
    }

    public Animal(){

    }
    public Animal(int id, String denumire){
        this.id =id;
        this.denumire=denumire;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean equals(Animal o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (id != animal.id) return false;
        return !(denumire != null ? !denumire.equals(animal.denumire) : animal.denumire != null);

    }

    @Override
    public String toString() {
        return "Animal{" +

                "denumire='" + denumire + '\'' +
                ", id=" + id +
                '}';
    }

}
