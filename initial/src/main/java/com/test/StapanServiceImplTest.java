package com.test;

import com.model.Stapan;
import com.service.IStapanSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by bristena.vrancianu on 9/17/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"resources/../../../spring-config.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class StapanServiceImplTest {

    @Autowired
    IStapanSerivce stapanSerivce;

    @Test
    public void testGetAll() throws Exception {
        List list = stapanSerivce.getAll();
        assertNotNull(list);
    }

    @Test
    public void testDelete() throws Exception {
        stapanSerivce.delete(1);
        Stapan stapanDeleted = stapanSerivce.getStapanById(1);
        assertNull(stapanDeleted);
    }

//    @Test
//    public void testUpdate() throws Exception {
//        Stapan stapan = new Stapan();
//        stapan.setNume("Popescu");
//        stapan.setCnp("1234567891234");
//        stapan.setActive(true);
//        stapan.setId(999);
//        Stapan stapanInserted = stapanSerivce.insert(stapan);
//        Stapan getStapan = stapanSerivce.getStapanById(stapanInserted.getId());
//        getStapan.setNume("test");
//        getStapan.setCnp("1234567890123");
//        getStapan.setActive(false);
//        stapanSerivce.update(getStapan.getId(), getStapan.getNume(), getStapan.getCnp(), getStapan.isActive());
//        Stapan stapanUpdated = stapanSerivce.getStapanById(stapanInserted.getId());
//        assertEquals(stapanInserted.getNume(), stapanUpdated.getNume());
//        assertEquals(stapanInserted.getCnp(), stapanUpdated.getCnp());
//    }

    @Test
    public void testInsert() throws Exception {
        Stapan stapan = new Stapan();
        stapan.setNume("Popescu");
        stapan.setCnp("1234567891234");
        stapan.setActive(false);
        Stapan stapanInserted = stapanSerivce.insert(stapan);
        assertNotNull(stapanInserted);
        assertEquals(stapanInserted.getCnp(), stapan.getCnp());
        assertEquals(stapanInserted.getNume(), stapan.getNume());
    }
}