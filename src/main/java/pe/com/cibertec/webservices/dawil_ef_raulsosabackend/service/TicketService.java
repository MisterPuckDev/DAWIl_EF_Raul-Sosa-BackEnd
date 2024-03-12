package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service;

import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Ticket;

import java.util.List;

public interface TicketService {

    public List<Ticket> list();

    public Ticket serachById(int id);

    public Ticket add(Ticket obj);

    public Ticket update(Ticket obj);

    public void delete(int id);
    
}
