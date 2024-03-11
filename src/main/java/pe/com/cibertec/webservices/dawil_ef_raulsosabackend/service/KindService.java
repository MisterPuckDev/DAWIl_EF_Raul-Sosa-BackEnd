package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service;

import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Kind;

import java.util.List;

public interface KindService {

    public List<Kind> list();

    public Kind serachById(int id);

    public Kind add(Kind obj);

    public Kind update(Kind obj);

    public Kind delete(int id);
    
}
