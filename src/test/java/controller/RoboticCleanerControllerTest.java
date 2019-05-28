package controller;

import document.RoboticCleanerRequestDocument;
import document.RoboticCleanerResponseDocument;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import service.CleanOilPatchService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class RoboticCleanerControllerTest {

    @Mock
    private CleanOilPatchService service;

    private ArrayList<Integer> areaSize;
    private ArrayList<Integer> startingPosition;
    private ArrayList<ArrayList<Integer>> oilPatches;
    private ArrayList<Integer> patch_one;
    private String navigationInstructions;
    private RoboticCleanerRequestDocument request;
    private RoboticCleanerResponseDocument response;

    private RoboticCleanerController controller;

    @Before
    public void setUp(){
        areaSize = new ArrayList<>();
        areaSize.add(5);
        areaSize.add(5);
        startingPosition = new ArrayList<>();
        startingPosition.add(1);
        startingPosition.add(2);
        oilPatches = new ArrayList<>();

        patch_one = new ArrayList<>();
        patch_one.add(1);
        patch_one.add(0);

        oilPatches.add(patch_one);

        navigationInstructions = "NNESEESWNWW";

        controller = new RoboticCleanerController();
        request = new RoboticCleanerRequestDocument(areaSize, startingPosition, oilPatches, navigationInstructions);
    }

    @Test
    public void test_valid_request(){
        when(service.cleanPatch(areaSize, startingPosition, oilPatches, navigationInstructions)).thenReturn(response);

        RoboticCleanerResponseDocument responseDocument = (RoboticCleanerResponseDocument) controller.clean(request).getBody();

        assertEquals(responseDocument, response);
    }
}
