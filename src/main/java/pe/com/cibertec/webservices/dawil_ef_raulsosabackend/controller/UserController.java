package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.User;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.projections.ReportUserForCategory;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<User>> list() {
        List<User> list = userService.list();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/search/{id}")
    @ResponseBody
    public ResponseEntity<User> search(@PathVariable("id") int id) {
        User ticket = null;

        try {
            ticket = userService.serachById(id);
            if (ticket == null) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/report/{id}")
    @ResponseBody
    public ResponseEntity<List<ReportUserForCategory>> getReport(@PathVariable("id") int id) {
        return new ResponseEntity<>(userService.getReport(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> add(@RequestBody User obj) {
        Map<String, Object> salida = new HashMap<>();

        try {
            obj.setId(0);
            User objUser = userService.add(obj);

            if (objUser == null) {
                salida.put("mensaje", "Ocurrio un error al intentar registrar");
            } else {
                salida.put("mensaje", "Registro con exito");
            }

        } catch (Exception e) {
            salida.put("mensaje", "Ocurrio un error durante el registro: " + e.getMessage());
            System.out.println("Ocurrio un error durante el registro: " + e.getMessage());
            return ResponseEntity.internalServerError().body(salida);
        }

        return ResponseEntity.ok(salida);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> update(@RequestBody User obj) {
        Map<String, Object> salida = new HashMap<>();

        try {
            User objUser = userService.update(obj);

            if (objUser == null) {
                salida.put("mensaje", "Ocurrio un error al intentar actualizar");
            } else {
                salida.put("mensaje", "Actualizacion con exito");
            }

        } catch (Exception e) {
            salida.put("mensaje", "Ocurrio un error durante la actualizacion: " + e.getMessage());
            System.out.println("Ocurrio un error durante la actualizacion: " + e.getMessage());
            return ResponseEntity.internalServerError().body(salida);
        }

        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") int id) {
        Map<String, Object> salida = new HashMap<>();

        try {
            userService.delete(id);
            salida.put("mensaje", "Eliminacion con exito");
        } catch (Exception e) {
            salida.put("mensaje", "Ocurrio un error durante la eliminacion: " + e.getMessage());
            System.out.println("Ocurrio un error durante la eliminacion: " + e.getMessage());
            return ResponseEntity.internalServerError().body(salida);
        }

        return ResponseEntity.ok(salida);
    }
    
}
