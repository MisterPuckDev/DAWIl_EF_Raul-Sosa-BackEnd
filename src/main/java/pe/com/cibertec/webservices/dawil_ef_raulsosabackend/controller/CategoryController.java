package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Category;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Category>> list() {
        List<Category> list = categoryService.list();
        return ResponseEntity.ok(list);
    }

}
