package controller;

import document.RoboticCleanerRequestDocument;
import document.RoboticCleanerResponseDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CleanOilPatchService;

@RestController
public class RoboticCleanerController {

    @Autowired
    CleanOilPatchService service;

    @RequestMapping("/")
    public RoboticCleanerResponseDocument clean(@RequestBody RoboticCleanerRequestDocument request) {
        RoboticCleanerResponseDocument response = new RoboticCleanerResponseDocument();
        response.setOilPatchesCleaned(request.getNavigationInstructions());
        return response;
    }

}
