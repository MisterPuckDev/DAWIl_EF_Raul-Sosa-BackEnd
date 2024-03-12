package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Status;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.repository.StatusRepository;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.StatusService;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> list() {
        return statusRepository.findAll();
    }

    @Override
    public Status serachById(int id) {
        return null;
    }

    @Override
    public Status add(Status obj) {
        return null;
    }

    @Override
    public Status update(Status obj) {
        return null;
    }

    @Override
    public Status delete(int id) {
        return null;
    }
}
