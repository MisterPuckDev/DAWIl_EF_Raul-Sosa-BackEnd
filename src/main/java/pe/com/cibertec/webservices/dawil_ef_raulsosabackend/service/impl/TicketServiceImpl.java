package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Ticket;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.repository.TicketRepository;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.TicketService;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public List<Ticket> list() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket serachById(int id) {
        return null;
    }

    @Override
    public Ticket add(Ticket obj) {
        return ticketRepository.save(obj);
    }

    @Override
    public Ticket update(Ticket obj) {
        return ticketRepository.save(obj);
    }

    @Override
    public void delete(int id) {
        ticketRepository.deleteById(id);
    }
}
