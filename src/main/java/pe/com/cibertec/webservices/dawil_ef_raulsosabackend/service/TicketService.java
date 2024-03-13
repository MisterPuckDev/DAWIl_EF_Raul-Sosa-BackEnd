package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service;

import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    public List<Ticket> list();

    public Optional<Ticket> serachById(int id);

    public Ticket add(Ticket obj);

    public Ticket update(Ticket obj);

    public void delete(int id);
    
}
