package com.hello;


import com.model.Animal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bristena.vrancianu on 9/8/2015.
 */
public class AnimalRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
    Animal a = new Animal();
        a.setDenumire(rs.getString("denumire"));
        a.setId(rs.getInt("id"));
        return a;
    }
}
