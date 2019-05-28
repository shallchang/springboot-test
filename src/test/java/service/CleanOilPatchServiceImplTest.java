package service;

import document.RoboticCleanerResponseDocument;
import org.junit.Before;
import org.junit.Test;
import service.exception.RobotOutBoundaryException;
import service.impl.CleanOilPatchServiceImpl;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CleanOilPatchServiceImplTest {

    private CleanOilPatchService service;

    @Before
    public void setUp(){
        service = new CleanOilPatchServiceImpl();
    }

    @Test
    public void test_valid_task(){
        ArrayList<Integer> areaSize = new ArrayList<>();
        areaSize.add(5);
        areaSize.add(5);
        ArrayList<Integer> startingPosition = new ArrayList<>();
        startingPosition.add(1);
        startingPosition.add(2);
        ArrayList<ArrayList<Integer>> oilPatches = new ArrayList<>();

        ArrayList<Integer> patch_one = new ArrayList<>();
        patch_one.add(1);
        patch_one.add(0);
        ArrayList<Integer> patch_two = new ArrayList<>();
        patch_two.add(2);
        patch_two.add(2);
        ArrayList<Integer> patch_three = new ArrayList<>();
        patch_three.add(2);
        patch_three.add(3);

        oilPatches.add(patch_one);
        oilPatches.add(patch_two);
        oilPatches.add(patch_three);

        String navigationInstructions = "NNESEESWNWW";

        RoboticCleanerResponseDocument response = service.cleanPatch(areaSize, startingPosition, oilPatches, navigationInstructions);

        assertEquals(response.getFinalPosition().get(0), new Integer(1));
        assertEquals(response.getFinalPosition().get(1), new Integer(3));
        assertEquals(response.getOilPatchesCleaned(), 1);
    }

    @Test
    public void test_revisit_oil_patch(){
        ArrayList<Integer> areaSize = new ArrayList<>();
        areaSize.add(3);
        areaSize.add(3);
        ArrayList<Integer> startingPosition = new ArrayList<>();
        startingPosition.add(1);
        startingPosition.add(1);
        ArrayList<ArrayList<Integer>> oilPatches = new ArrayList<>();

        ArrayList<Integer> patch_one = new ArrayList<>();
        patch_one.add(1);
        patch_one.add(2);
        ArrayList<Integer> patch_two = new ArrayList<>();
        patch_two.add(2);
        patch_two.add(2);

        oilPatches.add(patch_one);
        oilPatches.add(patch_two);

        String navigationInstructions = "NESWNESWNESW";

        RoboticCleanerResponseDocument response = service.cleanPatch(areaSize, startingPosition, oilPatches, navigationInstructions);

        assertEquals(response.getFinalPosition().get(0), new Integer(1));
        assertEquals(response.getFinalPosition().get(1), new Integer(1));
        assertEquals(response.getOilPatchesCleaned(), 2);
    }

    @Test(expected = RobotOutBoundaryException.class)
    public void test_robot_outside_boundary(){
        ArrayList<Integer> areaSize = new ArrayList<>();
        areaSize.add(5);
        areaSize.add(5);
        ArrayList<Integer> startingPosition = new ArrayList<>();
        startingPosition.add(1);
        startingPosition.add(2);
        ArrayList<ArrayList<Integer>> oilPatches = new ArrayList<>();

        ArrayList<Integer> patch_one = new ArrayList<>();
        patch_one.add(1);
        patch_one.add(0);
        ArrayList<Integer> patch_two = new ArrayList<>();
        patch_two.add(2);
        patch_two.add(2);
        ArrayList<Integer> patch_three = new ArrayList<>();
        patch_three.add(2);
        patch_three.add(3);

        oilPatches.add(patch_one);
        oilPatches.add(patch_two);
        oilPatches.add(patch_three);

        String navigationInstructions = "NNNNNNNN";

        service.cleanPatch(areaSize, startingPosition, oilPatches, navigationInstructions);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_pass_invalid_navigation_instruction(){
        ArrayList<Integer> areaSize = new ArrayList<>();
        areaSize.add(5);
        areaSize.add(5);
        ArrayList<Integer> startingPosition = new ArrayList<>();
        startingPosition.add(1);
        startingPosition.add(2);
        ArrayList<ArrayList<Integer>> oilPatches = new ArrayList<>();

        ArrayList<Integer> patch_one = new ArrayList<>();
        patch_one.add(1);
        patch_one.add(0);
        ArrayList<Integer> patch_two = new ArrayList<>();
        patch_two.add(2);
        patch_two.add(2);
        ArrayList<Integer> patch_three = new ArrayList<>();
        patch_three.add(2);
        patch_three.add(3);

        oilPatches.add(patch_one);
        oilPatches.add(patch_two);
        oilPatches.add(patch_three);

        String navigationInstructions = "NNASW";

        service.cleanPatch(areaSize, startingPosition, oilPatches, navigationInstructions);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_pass_invalid_coordinates(){
        ArrayList<Integer> areaSize = new ArrayList<>();
        areaSize.add(-1);
        areaSize.add(5);
        ArrayList<Integer> startingPosition = new ArrayList<>();
        startingPosition.add(1);
        startingPosition.add(2);
        ArrayList<ArrayList<Integer>> oilPatches = new ArrayList<>();

        ArrayList<Integer> patch_one = new ArrayList<>();
        patch_one.add(1);
        patch_one.add(0);
        ArrayList<Integer> patch_two = new ArrayList<>();
        patch_two.add(2);
        patch_two.add(2);
        ArrayList<Integer> patch_three = new ArrayList<>();
        patch_three.add(2);
        patch_three.add(3);

        oilPatches.add(patch_one);
        oilPatches.add(patch_two);
        oilPatches.add(patch_three);

        String navigationInstructions = "N";

        service.cleanPatch(areaSize, startingPosition, oilPatches, navigationInstructions);

    }

    @Test(expected = RobotOutBoundaryException.class)
    public void test_starting_location_outside_boundary(){
        ArrayList<Integer> areaSize = new ArrayList<>();
        areaSize.add(3);
        areaSize.add(3);
        ArrayList<Integer> startingPosition = new ArrayList<>();
        startingPosition.add(4);
        startingPosition.add(5);
        ArrayList<ArrayList<Integer>> oilPatches = new ArrayList<>();

        ArrayList<Integer> patch_one = new ArrayList<>();
        patch_one.add(1);
        patch_one.add(0);
        ArrayList<Integer> patch_two = new ArrayList<>();
        patch_two.add(2);
        patch_two.add(2);
        ArrayList<Integer> patch_three = new ArrayList<>();
        patch_three.add(2);
        patch_three.add(3);

        oilPatches.add(patch_one);
        oilPatches.add(patch_two);
        oilPatches.add(patch_three);

        String navigationInstructions = "N";

        service.cleanPatch(areaSize, startingPosition, oilPatches, navigationInstructions);
    }




}
