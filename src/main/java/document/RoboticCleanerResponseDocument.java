package document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class RoboticCleanerResponseDocument {

    @NotNull
    @Size(min = 2, max = 2)
    private ArrayList<Integer> finalPosition;

    @NotNull
    private int oilPatchesCleaned;

}
