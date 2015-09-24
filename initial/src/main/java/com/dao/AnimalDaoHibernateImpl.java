package com.dao;

/**
 * Created by bristena.vrancianu on 9/9/2015.
 */

import com.model.Animal;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.List;

public class AnimalDaoHibernateImpl extends HibernateDaoSupport implements IAnimalDao {
    private final Logger logger = LoggerFactory.getLogger(Animal.class);

    @Override
    public List<Animal> getAnimals() {
        List list = getHibernateTemplate().loadAll(Animal.class);
        logger.debug("getAnimals()");
        return list;
    }


    @Override
    public void delete(int id) {
        Animal a = getAnimalById(id);
        getHibernateTemplate().delete(a);
        logger.debug("deleting animal " + id);
    }

    @Override
    public void update(int id, String denumire, boolean homeless, int idStapan) {
        Animal a = new Animal();
        a.setDenumire(denumire);

        getHibernateTemplate().update(a);
    }

    @Override
    public Animal getAnimalById(int id) {
//    List list = getHibernateTemplate().find("from Animal where id = ?", id);
        Animal animal = getHibernateTemplate().get(Animal.class, id);
        if (animal != null) {
            logger.info("get animal by id " + id);
            return animal;
        }
        else {
            logger.info("nu exista animal cu id-ul  " + id);
            return null;
        }
    }


    @Override
    public Animal insert(Animal a) {
        getHibernateTemplate().save(a);
        return a;
    }

    @Override
    public void init() throws SQLException {

    }

    @Override
    public void close() throws SQLException {

    }

    @Override
    public void insertBatchUpdate(List<Animal> list) {

    }

    @Override
    public List<Animal> getListAnimalsByIdStapan(int id) {
        List list = getHibernateTemplate().find("from Animal where idStapan = ?", id);
        return list;
    }

    @Override
    public List<Animal> getDenumireAnimal(String nume) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        Query query = session.createQuery("from Animal a, Stapan s where s.id=a.idStapan and s.nume = :nume");

        query.setParameter("nume", nume);
        List<Animal> results = query.list();
        session.close();
        return results;
    }

    @Override
    public Animal getAnimalByDenumire(String denumire) {
        List list = getHibernateTemplate().find("from Animal where denumire = ?", denumire);
        //      Animal animal = getHibernateTemplate().get(Animal.class, id);
        return (Animal) list.get(0);
    }

    @Override
    public void updateHomelessAnimal(int idAnimal, boolean homeless) {

    }

}
