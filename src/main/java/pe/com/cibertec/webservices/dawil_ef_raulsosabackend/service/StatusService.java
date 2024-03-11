package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service;

import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Status;

import java.util.List;

public interface StatusService {

    public List<Status> list();

    public Status serachById(int id);

    public Status add(Status obj);

    public Status update(Status obj);

    public Status delete(int id);
    
}
