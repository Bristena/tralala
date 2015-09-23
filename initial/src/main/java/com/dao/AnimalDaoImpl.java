package com.dao;

import com.hello.AnimalRowMapper;
import com.model.Animal;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bristena.vrancianu on 9/8/2015.
 */

public class AnimalDaoImpl implements IAnimalDao {
    private DataSource ds;

    @Override
    public List<Animal> getDenumireAnimal(String nume) {
        return null;
    }

    @Override
    public Animal getAnimalByDenumire(String denumire) {
        return null;
    }

    @Override
    public void updateHomelessAnimal(int idAnimal, boolean homeless) {
        jdbcTemplate.update("update Animal set homeless = ? where idAnimal = ?", homeless, idAnimal);
    }

    private JdbcTemplate jdbcTemplate;
    private Connection con;

    @PostConstruct
    public void init() throws SQLException {
        con = ds.getConnection();
    }

    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Animal> getAnimals() {
       jdbcTemplate = new JdbcTemplate(ds);
        String sql = "select * from animal";
        List<Animal> list = new ArrayList<Animal>();
        List<Map<String, Object>>rows = jdbcTemplate.queryForList(sql);
        for(Map row : rows){
            Animal a = new Animal();
            a.setDenumire((String) row.get("denumire"));
            a.setId(Integer.parseInt(String.valueOf(row.get("idAnimal"))));
            a.setHomeless(Boolean.parseBoolean(String.valueOf(row.get("homeless"))));
            a.setIdStapan(Integer.parseInt(String.valueOf(row.get("idStapan"))));
            list.add(a);
        }
        return list;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate = new JdbcTemplate(ds);
        String sql = "delete from animal where idAnimal = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public void update(int id, String denumire, boolean homeless, int idStapan) {
        jdbcTemplate.update("update animal set denumire = ?, homeless = ?, idStapan = ? where idAnimal = ?", denumire,homeless, idStapan, id);

    }

    @SuppressWarnings({"unchecked"})
    public Animal getAnimalById(int id) {
        String sql = "select * from animal where id = ?";
        jdbcTemplate = new JdbcTemplate(ds);
        Animal a = (Animal) jdbcTemplate.queryForObject(sql, new Object[]{id}, new AnimalRowMapper());
        return a;

    }

    @Override
    public Animal insert(Animal a) {
//        String sql = "insert into animal (denumire, idStapan, homeless ) values (?, ?,?)";
//        Animal animal = new Animal();
//        PreparedStatement ps = null;
//      //  PreparedStatement ps1 = null;
//        try {
//
//            ps = con.prepareStatement(sql);
//            ps.setString(1, a.getDenumire());
//            ps.setInt(2, a.getIdStapan());
//            ps.setBoolean(3, a.isHomeless());
//            ps.executeUpdate();
//            String select = "select * from animal";
//            ps= con.prepareStatement(select);
//            ResultSet rs =  ps.executeQuery();
//            while( rs.next()) {
//                animal.setId(rs.getInt("idAnimal"));
//                animal.setDenumire(rs.getString("denumire"));
//                animal.setHomeless(rs.getBoolean("homeless"));
//                animal.setIdStapan(rs.getInt("idStapan"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ps.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        jdbcTemplate = new JdbcTemplate(ds);
        String sql = "insert into animal (denumire, idStapan, homeless) values (?,?,?)";
        jdbcTemplate.update(sql, a.getDenumire(), a.getIdStapan(), a.isHomeless());

        return  a;
    }

    public void insertBatchUpdate(List<Animal> list){
        jdbcTemplate = new JdbcTemplate(ds);
        String sql = "insert into animal (denumire) values (?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Animal a = list.get(i);
                preparedStatement.setString(1, a.getDenumire());
            }

            @Override
            public int getBatchSize() {
                return list.size();
            }
        });
    }

    @Override
    public List<Animal> getListAnimalsByIdStapan(int id) {
        String sql = "select * from animal where idStapan = ?";
        jdbcTemplate = new JdbcTemplate(ds);
        List<Animal> list = new ArrayList<Animal>();
        List<Map<String, Object>>rows = jdbcTemplate.queryForList(sql, id);
        for(Map row : rows){
            Animal a = new Animal();
            a.setDenumire((String) row.get("denumire"));
            a.setId(Integer.parseInt(String.valueOf(row.get("idAnimal"))));
            a.setHomeless(Boolean.parseBoolean(String.valueOf(row.get("homeless"))));
            a.setIdStapan(Integer.parseInt(String.valueOf(row.get("idStapan"))));
            list.add(a);
        }
        return list;

    }

    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertJdbc(Animal animal){
        String sql = "insert into animal(denumire) values (?)";
        jdbcTemplate = new JdbcTemplate(ds);
        jdbcTemplate.update(sql, new Object[]{animal.getDenumire()});
    }


}
