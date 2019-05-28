package service.impl;

import document.RoboticCleanerResponseDocument;
import org.springframework.stereotype.Service;
import service.CleanOilPatchService;

import java.util.ArrayList;

@Service
public class CleanOilPatchServiceImpl implements CleanOilPatchService {

    @Override
    public RoboticCleanerResponseDocument cleanPatch(ArrayList<Integer> areaSize, ArrayList<Integer> startingPosition, ArrayList<ArrayList<Integer>> oilPatches, String navigationInstructions) {
        return null;
    }
}
