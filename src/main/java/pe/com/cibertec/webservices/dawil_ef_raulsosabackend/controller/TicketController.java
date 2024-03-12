package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Ticket;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.TicketService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Ticket>> list() {
        List<Ticket> list = ticketService.list();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/search/{id}")
    @ResponseBody
    public ResponseEntity<Ticket> search(@PathVariable("id") int id) {
        Ticket ticket = null;

        try {
            ticket = ticketService.serachById(id);
            if (ticket == null) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(ticket);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> add(@RequestBody Ticket obj) {
        Map<String, Object> salida = new HashMap<>();

        try {
            obj.setId(0);
            Ticket objTicket = ticketService.add(obj);

            if (objTicket == null) {
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
    public ResponseEntity<Map<String, Object>> update(@RequestBody Ticket obj) {
        Map<String, Object> salida = new HashMap<>();

        try {
            Ticket objTicket = ticketService.update(obj);

            if (objTicket == null) {
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
            ticketService.delete(id);
            salida.put("mensaje", "Eliminacion con exito");
        } catch (Exception e) {
            salida.put("mensaje", "Ocurrio un error durante la eliminacion: " + e.getMessage());
            System.out.println("Ocurrio un error durante la eliminacion: " + e.getMessage());
            return ResponseEntity.internalServerError().body(salida);
        }

        return ResponseEntity.ok(salida);
    }

}
