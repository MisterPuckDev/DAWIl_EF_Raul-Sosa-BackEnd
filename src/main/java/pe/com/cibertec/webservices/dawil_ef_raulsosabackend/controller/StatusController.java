package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Status;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.StatusService;

import java.util.List;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Status>> list() {
        List<Status> list = statusService.list();
        return ResponseEntity.ok(list);
    }

}
