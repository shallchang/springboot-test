package document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class RoboticCleanerRequestDocument {

//    private ArrayList<Integer> areaSize;
//
//    private ArrayList<Integer> startingPosition;
//
//    private ArrayList<ArrayList<Integer>> oilPatches;

    private int navigationInstructions;

}
