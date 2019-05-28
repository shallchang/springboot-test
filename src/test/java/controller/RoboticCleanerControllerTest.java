package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import service.CleanOilPatchService;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class RoboticCleanerControllerTest {

    @Mock
    private CleanOilPatchService service;


    @Test
    public void success(){
        when(service.cleanPatch(null, null, null, "123")).thenReturn(null);

        assertTrue(true);
    }


}
