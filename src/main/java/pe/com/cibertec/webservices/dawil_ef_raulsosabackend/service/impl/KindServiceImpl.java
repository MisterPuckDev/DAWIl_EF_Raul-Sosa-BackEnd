package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Kind;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.repository.KindRepository;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.KindService;

import java.util.List;

@Service
public class KindServiceImpl implements KindService {

    @Autowired
    KindRepository kindRepository;

    @Override
    public List<Kind> list() {
        return kindRepository.findAll();
    }

    @Override
    public Kind serachById(int id) {
        return null;
    }

    @Override
    public Kind add(Kind obj) {
        return null;
    }

    @Override
    public Kind update(Kind obj) {
        return null;
    }

    @Override
    public Kind delete(int id) {
        return null;
    }
}
