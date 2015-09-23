package com.service;

import com.dao.IStapanDao;
import com.model.Stapan;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bristena.vrancianu on 9/11/2015.
 */
public interface IStapanSerivce {

    public List<Stapan> getAll();
    public void delete(int id);
    public void update(int id, String nume, String cnp, Boolean active);
    public Stapan getStapanById(int id);
    public Stapan insert(Stapan a);
    public void close() throws SQLException;
    public void insertBatchUpdate(List<Stapan> list);
    public void setStapanDao(IStapanDao StapanDao);
    public boolean isStapanActive(int idStapan);
}
