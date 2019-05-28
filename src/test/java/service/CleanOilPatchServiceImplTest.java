package service;

import document.RoboticCleanerResponseDocument;
import org.junit.Before;
import org.junit.Test;
import service.impl.CleanOilPatchServiceImpl;

import static org.junit.Assert.assertEquals;

public class CleanOilPatchServiceImplTest {

    private CleanOilPatchService service;

    @Before
    public void setUp(){
        service = new CleanOilPatchServiceImpl();
    }

    @Test
    public void clean(){
        RoboticCleanerResponseDocument response = service.cleanPatch(null, null, null, "a");

        assertEquals(response, null);
    }
}
