package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Project;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Project>> list() {
        List<Project> list = projectService.list();
        return ResponseEntity.ok(list);
    }

}
