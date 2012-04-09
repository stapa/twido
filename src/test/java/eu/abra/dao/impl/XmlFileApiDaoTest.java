package eu.abra.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-test.xml"})
public class XmlFileApiDaoTest {

    @Autowired
    private XmlFileApiDao dao;

    @Test
    public void testGetResources() throws Exception {
        assertNotNull(dao.getResources());
    }

    @Test
    public void testGetByPath() throws Exception {
        assertNull(dao.getByPath("An invalid path String"));
    }
}
