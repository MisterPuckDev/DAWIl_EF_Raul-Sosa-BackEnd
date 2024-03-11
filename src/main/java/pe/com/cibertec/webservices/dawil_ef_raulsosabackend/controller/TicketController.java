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
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> update(@RequestBody Ticket obj) {
        Map<String, Object> salida = new HashMap<>();
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") int id) {
        Map<String, Object> salida = new HashMap<>();
        return ResponseEntity.ok(salida);
    }

}
