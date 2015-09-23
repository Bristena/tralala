package com.dao;

import com.model.Stapan;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bristena.vrancianu on 9/11/2015.
 */
public class StapanDaoHibernateImpl extends HibernateDaoSupport implements  IStapanDao{
    public List<Stapan>getAll(){

        List<Stapan> list = getHibernateTemplate().loadAll(Stapan.class);
        return list;
    }

    @Override
    public void delete(int id) {
        getHibernateTemplate().delete(getStapanById(id));
    }

    @Override
    public void update(int id, String nume, String cnp, Boolean active) {
        Stapan stapan = getStapanById(id);
        stapan.setNume(nume);
        stapan.setCnp(cnp);
        getHibernateTemplate().update(stapan);
    }

    @Override
    public Stapan getStapanById(int id) {
         Stapan stapan = getHibernateTemplate().get(Stapan.class, id);
        return stapan;
    }

    @Override
    public Stapan insert(Stapan a) {
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
    public void insertBatchUpdate(List<Stapan> list) {

    }

    @Override
    public void clean() {
        getHibernateTemplate().bulkUpdate("delete from Stapan");
    }

    @Override
    public void updateActiveStapan(int id, Boolean active) {

    }


}
