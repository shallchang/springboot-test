package service;

import document.RoboticCleanerResponseDocument;

import java.util.ArrayList;

/**
 * Service operations for clean oil patch
 *
 * @author shawnzhang
 */
public interface CleanOilPatchService {

    /**
     * Clean oil patches in the routine
     *
     * @param areaSize
     * @param startingPosition
     * @param oilPatches
     * @param navigationInstructions
     * @return RoboticCleanerResponseDocument
     */
    RoboticCleanerResponseDocument cleanPatch(ArrayList<Integer> areaSize, ArrayList<Integer> startingPosition, ArrayList<ArrayList<Integer>> oilPatches, String navigationInstructions);

}
