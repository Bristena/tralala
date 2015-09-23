package com.dao;

import com.hello.StapanRowMapper;
import com.model.Stapan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bristena.vrancianu on 9/18/2015.
 */
public class StapanDaoImpl implements IStapanDao {
    private JdbcTemplate jdbcTemplate;
    private DataSource ds;

    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Stapan> getAll() {
        jdbcTemplate = new JdbcTemplate(ds);
        String sql = "select * from stapan";
        List<Stapan> list = new ArrayList<Stapan>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            Stapan stapan = new Stapan();
            stapan.setNume((String) row.get("nume"));
            stapan.setId(Integer.parseInt(String.valueOf(row.get("idStapan"))));
            stapan.setActive(Boolean.parseBoolean(String.valueOf(row.get("active"))));
            stapan.setCnp((String) row.get("cnp"));
            list.add(stapan);
        }
        return list;

    }

    @Override
    public void delete(int id) {
        jdbcTemplate = new JdbcTemplate(ds);
        String sql = "delete from stapan where idStapan = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public void update(int id, String nume, String cnp, Boolean active) {
        jdbcTemplate = new JdbcTemplate(ds);
        jdbcTemplate.update("update stapan set nume =?, cnp = ?, active = ? where idStapan = ?", nume, cnp, active, id);
    }

    @Override
    public Stapan getStapanById(int id) {
        jdbcTemplate = new JdbcTemplate(ds);
        String sql = "select * from stapan where idStapan = ?";
        Stapan stapan = (Stapan) jdbcTemplate.queryForObject(sql, new Object[]{id}, new StapanRowMapper());
        return stapan;

    }

    @Override
    public Stapan insert(Stapan a) {
      jdbcTemplate = new JdbcTemplate(ds);
        String sql = "insert into stapan(nume, cnp, active) values (?,?,?)";
        jdbcTemplate.update(sql, a.getNume(), a.getCnp(), a.isActive());
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

    }

    @Override
    public void updateActiveStapan(int id, Boolean active) {
        jdbcTemplate = new JdbcTemplate(ds);
        jdbcTemplate.update("update stapan set nactive = ? where idStapan = ?", active, id);
    }
}
