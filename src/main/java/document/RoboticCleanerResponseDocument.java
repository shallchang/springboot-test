package document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class RoboticCleanerResponseDocument {

    private ArrayList<Integer> finalPosition;

    private int oilPatchesCleaned;

}
