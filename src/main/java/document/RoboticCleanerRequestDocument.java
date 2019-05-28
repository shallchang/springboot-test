package document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class RoboticCleanerRequestDocument {

    @NotNull
    @Size(min = 2, max = 2)
    private ArrayList<Integer> areaSize;

    @NotNull
    @Size(min = 2, max = 2)
    private ArrayList<Integer> startingPosition;

    @NotNull
    private ArrayList<ArrayList<Integer>> oilPatches;

    @NotNull
    private String navigationInstructions;

}
