package document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class RoboticCleanerResponseDocument {

    @NotNull
    @Size(min = 2, max = 2)
    private ArrayList<Integer> finalPosition;

    @NotNull
    private int oilPatchesCleaned;

}
