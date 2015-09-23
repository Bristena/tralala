package com.test;

import com.dao.IStapanDao;
import com.dao.StapanDaoImpl;
import com.model.Stapan;
import com.service.IStapanSerivce;
import com.service.StapanServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by bristena.vrancianu on 9/17/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"resources/../../../spring-config.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class StapanServiceMockitoTest {
    @InjectMocks
    @Autowired
    IStapanSerivce stapanSerivce;

    @Mock
    IStapanDao stapanDao;

    @Test
    public void test(){
        IStapanSerivce stapanSerivce = mock(StapanServiceImpl.class);
        List<Stapan> list = new ArrayList<Stapan>();
        when(stapanSerivce.getAll()).thenReturn(list);
        assertNotNull(list);
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testInsert(){
        Stapan stapan = new Stapan();
        stapan.setCnp("123456789123");
        stapan.setNume("test");
        //ii pun si id, campurile sa fie aceleasi
        Stapan stapanInserted = new Stapan();
        when(stapanDao.insert(stapan)).thenReturn(stapan);
        assertNotNull(stapanSerivce);
        assertNotNull(stapan);
    }

//    @Test
//    public void testDelete(){
//        Stapan stapan = new Stapan();
//        stapan.setCnp("123456789123");
//        stapan.setNume("test");
//        Stapan stapanInserted = stapanDao.insert(stapan);
//        int idStapan = stapanInserted.getId();
////        when(stapanDao.delete(idStapan))
//        verify(stapanDao, atLeastOnce()).delete(idStapan);
//
//    }

    @Test
    public void testCreateList(){
      //  IStapanDao stapanDao = mock(StapanDaoImpl.class);

    }

}
