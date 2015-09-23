package com.dao;

import com.model.Stapan;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bristena.vrancianu on 9/11/2015.
 */
public interface IStapanDao {
    public List<Stapan> getAll();
    public void delete(int id);
    public void update(int id, String nume, String cnp, Boolean active);
    public Stapan getStapanById(int id);
    public Stapan insert(Stapan a);
    public void init() throws SQLException;
    public void close() throws  SQLException;
    public void insertBatchUpdate(List<Stapan> list);
    public void clean();
    public void updateActiveStapan(int id, Boolean active);

}
