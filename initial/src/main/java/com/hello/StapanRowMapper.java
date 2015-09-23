package com.hello;

import com.model.Stapan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bristena.vrancianu on 9/18/2015.
 */
public class StapanRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Stapan stapan = new Stapan();
        stapan.setCnp(rs.getString("cnp"));
        stapan.setNume(rs.getString("nume"));
        stapan.setActive(rs.getBoolean("active"));
        stapan.setId(rs.getInt("idStapan"));

        return stapan;
    }

}
