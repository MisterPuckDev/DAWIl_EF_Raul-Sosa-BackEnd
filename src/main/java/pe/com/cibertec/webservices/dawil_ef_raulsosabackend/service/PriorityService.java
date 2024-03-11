package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service;

import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Priority;

import java.util.List;

public interface PriorityService {

    public List<Priority> list();

    public Priority serachById(int id);

    public Priority add(Priority obj);

    public Priority update(Priority obj);

    public Priority delete(int id);
    
}
