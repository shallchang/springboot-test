package controller;

import document.RoboticCleanerRequestDocument;
import document.RoboticCleanerResponseDocument;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.CleanOilPatchService;
import service.exception.RobotOutBoundaryException;

import java.util.ArrayList;

@Slf4j
@RestController
@Api(value = "Robotic Cleaner Task", description = "Navigate a robot in area to clean oil patches")
public class RoboticCleanerController {

    @Autowired
    CleanOilPatchService service;

    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Robot outside boundary"),
            @ApiResponse(code = 400, message = "Invalid navigation instruction passed")})
    @ApiOperation(value = "Navigate robot in the area to clean oil patches", response = RoboticCleanerResponseDocument.class)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity clean(@RequestBody RoboticCleanerRequestDocument request) {
        log.info("Received request:" + request.toString());

        ArrayList<Integer> areaSize = request.getAreaSize();
        ArrayList<Integer> startingPosition = request.getStartingPosition();
        ArrayList<ArrayList<Integer>> oilPatches = request.getOilPatches();
        String navigationInstructions = request.getNavigationInstructions();

        try {
            RoboticCleanerResponseDocument response = service.cleanPatch(areaSize, startingPosition, oilPatches, navigationInstructions);
            log.info("Return response: " + response.toString());
            return ResponseEntity.ok(response);
        }catch (RobotOutBoundaryException e){
            log.info("Logged exception: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (IllegalArgumentException e){
            log.info("Logged exception: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e){
            log.info("Logged exception: " + e.getMessage());
            return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
        }
    }

}
