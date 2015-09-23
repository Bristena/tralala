//package com.test;
//
//import com.dao.IStapanDao;
//import com.model.Animal;
//import com.model.Stapan;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.transaction.TransactionConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
///**
// * Created by bristena.vrancianu on 9/17/2015.
// */
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"resources/../../../spring-config.xml"})
//@Transactional
//@TransactionConfiguration(defaultRollback=true)
//public class StapanDaoHibernateImplTest {
//    @Autowired
//    IStapanDao stapanDao;
//
//    @Before
//    public void setUp(){
//
//    }
//
//    @Test
//    public void testGetAll() throws Exception {
//        List<Stapan> list = stapanDao.getAll();
//       assertNotNull(list);
//
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        stapanDao.delete(1);
//        Stapan stapanDeleted = stapanDao.getStapanById(1);
//        assertNull(stapanDeleted);
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//
//        Stapan stapan = stapanDao.getStapanById(5);
//        stapan.setNume("test");
//        stapan.setCnp("1234567890123");
//        stapanDao.update(stapan.getId(), stapan.getNume(), stapan.getCnp(), stapan.isActive());
//        Stapan stapanUpdated = stapanDao.getStapanById(5);
//        assertEquals(stapan.getNume(), stapanUpdated.getNume());
//        assertEquals(stapan.getCnp(), stapanUpdated.getCnp());
//
//    }
//
//    @Test
//    public void testInsert() throws Exception {
//        Stapan stapan = new Stapan();
//        stapan.setNume("Popescu");
//        stapan.setCnp("1234567891234");
//        Stapan stapanInserted = stapanDao.insert(stapan);
//        assertNotNull(stapanInserted);
//        assertEquals(stapanInserted.getId(), stapan.getId());
//        assertEquals(stapanInserted.getCnp(), stapan.getCnp());
//        assertEquals(stapanInserted.getNume(), stapan.getNume());
//
//
//
//    }
//}