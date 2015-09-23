package com.service;

import com.dao.IStapanDao;
import com.model.Stapan;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bristena.vrancianu on 9/11/2015.
 */
public class StapanServiceImpl  implements IStapanSerivce {

    private IStapanDao stapanDao;

    public void setStapanDao(IStapanDao stapanDao){
        this.stapanDao = stapanDao;
    }
    @Override
    public List<Stapan> getAll() {
        return stapanDao.getAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(int id) {
        stapanDao.delete(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(int id, String nume, String cnp, Boolean active) {

        stapanDao.update(id, nume, cnp, active);

    }
    @Override
    public boolean isStapanActive(int idStapan) {
        Stapan stapan = stapanDao.getStapanById(idStapan);
        if (stapan.isActive()) {
            return true;
        }
        return false;
    }

    @Override
    public Stapan getStapanById(int id) {
        return stapanDao.getStapanById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Stapan insert(Stapan a) {
        return stapanDao.insert(a);
    }

    @Override
    public void close() throws SQLException {

    }

    @Override
    public void insertBatchUpdate(List<Stapan> list) {

    }


}
