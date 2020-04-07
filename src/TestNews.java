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
     */
    @Test
    public void TestCreate() throws Exception {
        NewsDAO result = NewsDAO.create("News9", "Content55", "20000210", 1);
        assertEquals("News9", result.getTitle());
    }

    /**
     * Test of SaveNews method, of class NewsDAO.
     */
    @Test
    public void TestSave() throws Exception {
        NewsDAO result = NewsDAO.readNewsById(1);
        result.setTitle("News1");
        result.save(1);

        result = NewsDAO.readNewsById(1);
        assertEquals("News1", result.getTitle());
    }

    /**
     * Test of DeleteNews method, of class NewsDAO.
     */
    @Test
    public void TestDelete() throws Exception {
        assertEquals(true, NewsDAO.delete(7));

    }

    /**
     * Test of readNewsById method, of class NewsDAO.
     */
    @Test
    public void TestReadNewsById() throws Exception {
        NewsDAO result = NewsDAO.readNewsById(2);
        assertEquals("News2", result.getTitle());
    }

    /**
     * Test of readArrayNewsByIdJournalist method, of class NewsDAO.
     */
    @Test
    public void TestReadArrayByIdJournalist() throws Exception {
        ArrayList<NewsDAO> result = NewsDAO.getByIdJournalist(1);
        assertEquals("News1", result.get(0).getTitle());
        assertEquals("News4", result.get(1).getTitle());
    }


}

