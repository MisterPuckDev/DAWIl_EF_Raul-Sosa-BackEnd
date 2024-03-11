package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Priority;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.PriorityService;

import java.util.List;

@RestController
@RequestMapping("/priority")
@CrossOrigin(origins = "http://localhost:4200")
public class PriorityController {

    @Autowired
    private PriorityService priorityService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Priority>> list() {
        List<Priority> list = priorityService.list();
        return ResponseEntity.ok(list);
    }
    
}
