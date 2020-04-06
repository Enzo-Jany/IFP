import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.internal.Utils;

import static org.junit.Assert.*;

public class TestNews {

    /**
     * Test of CreateNews method, of class NewsDAO.
     *//*
    @Test
    public void Create() throws Exception {
        NewsDAO result = NewsDAO.create("TitreTest", "ContentTest", 2);
        assertEquals("TitreTest", result.getTitle());
    }

    /**
     * Test of getByID method, of class NewsDAO.
     */


    @Test
    public void TestCreate() throws Exception {
        NewsDAO result = NewsDAO.create("4000", "2", "20000210", 1);
        assertEquals("4000", result.getTitle());
       //

    }

    /**
     * Test of getByID method, of class NewsDAO.
     */
    @Test
    public void TestReadNewsById() throws Exception {
        NewsDAO result = NewsDAO.readNewsById(1);
        assertEquals("News1", result.getTitle());
    }
}

