package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Kind;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.KindService;

import java.util.List;

@RestController
@RequestMapping("/kind")
@CrossOrigin(origins = "http://localhost:4200")
public class KindController {

    @Autowired
    private KindService kindService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Kind>> list() {
        List<Kind> list = kindService.list();
        return ResponseEntity.ok(list);
    }
    
}
