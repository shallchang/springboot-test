package controller;

import document.RoboticCleanerRequestDocument;
import document.RoboticCleanerResponseDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CleanOilPatchService;
import service.exception.RobotOutBoundaryException;

import java.util.ArrayList;

@Slf4j
@RestController
public class RoboticCleanerController {

    @Autowired
    CleanOilPatchService service;

    @RequestMapping("/")
    public ResponseEntity clean(@RequestBody RoboticCleanerRequestDocument request) {
        log.info("Received request:" + request.toString());

        ArrayList<Integer> areaSize = request.getAreaSize();
        ArrayList<Integer> startingPosition = request.getStartingPosition();
        ArrayList<ArrayList<Integer>> oilPatches = request.getOilPatches();
        String navigationInstructions = request.getNavigationInstructions();

        try {
            RoboticCleanerResponseDocument response = service.cleanPatch(areaSize, startingPosition, oilPatches, navigationInstructions);
            return ResponseEntity.ok(response);
        }catch (RobotOutBoundaryException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
        }
    }

}
