package service.impl;

import document.RoboticCleanerResponseDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import service.CleanOilPatchService;
import service.exception.RobotOutBoundaryException;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
@Service
public class CleanOilPatchServiceImpl implements CleanOilPatchService {

    @Override
    public RoboticCleanerResponseDocument cleanPatch(ArrayList<Integer> areaSize, ArrayList<Integer> startingPosition, ArrayList<ArrayList<Integer>> oilPatches, String navigationInstructions) {
        final int max_x_axis = areaSize.get(0);
        final int max_y_axis = areaSize.get(1);
        int x_axis = startingPosition.get(0);
        int y_axis = startingPosition.get(1);
        int oilPatchesCleaned = 0;
        HashMap<Integer, ArrayList<Integer>> oilPatchMap = createOilPatchMap(oilPatches);

        for (int i = 0; i < navigationInstructions.length(); i++){
            if(navigationInstructions.charAt(i) == 'N'){
                y_axis++;
            }else if(navigationInstructions.charAt(i) == 'S'){
                y_axis--;
            }else if(navigationInstructions.charAt(i) == 'E'){
                x_axis++;
            }else if(navigationInstructions.charAt(i) == 'W'){
                x_axis--;
            }else{
                throw new IllegalArgumentException("Invalid navigation instruction passed!");
            }

            if (x_axis == max_x_axis || y_axis == max_y_axis || x_axis < 0 || y_axis < 0){
                throw new RobotOutBoundaryException("Robot cannot be navigated outside of boundary!");
            }

            if (oilPatchMap.containsKey(x_axis)){
                ArrayList<Integer> y_list = oilPatchMap.get(x_axis);
                if (y_list.contains(y_axis)){
                    y_list.remove(new Integer(y_axis));
                    if (y_list.isEmpty()){
                        oilPatchMap.remove(x_axis);
                    }else{
                        oilPatchMap.put(x_axis, y_list);
                    }
                    oilPatchesCleaned++;
                }
            }
        }

        ArrayList<Integer> finalPosition = new ArrayList<>();
        finalPosition.add(x_axis);
        finalPosition.add(y_axis);

        return new RoboticCleanerResponseDocument(finalPosition, oilPatchesCleaned);
    }

    private HashMap<Integer, ArrayList<Integer>> createOilPatchMap(ArrayList<ArrayList<Integer>> oilPatches){
        HashMap<Integer, ArrayList<Integer>> oilPatchMap = new HashMap<>();

        for (ArrayList<Integer> oilPatch: oilPatches){
            int x_axis = oilPatch.get(0);
            int y_axis = oilPatch.get(1);

            if(oilPatchMap.containsKey(x_axis)) {
                ArrayList<Integer> y_list = oilPatchMap.get(x_axis);
                y_list.add(y_axis);
                oilPatchMap.put(x_axis, y_list);
            }else{
                ArrayList<Integer> y_list = new ArrayList<>();
                y_list.add(y_axis);
                oilPatchMap.put(x_axis, y_list);
            }
        }

        return oilPatchMap;
    }
}
