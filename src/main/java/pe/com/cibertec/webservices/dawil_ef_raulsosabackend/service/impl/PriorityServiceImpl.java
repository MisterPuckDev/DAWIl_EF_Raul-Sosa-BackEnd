package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Priority;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.repository.PriorityRepository;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.PriorityService;

import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    PriorityRepository priorityRepository;

    @Override
    public List<Priority> list() {
        return priorityRepository.findAll();
    }

    @Override
    public Priority serachById(int id) {
        return null;
    }

    @Override
    public Priority add(Priority obj) {
        return null;
    }

    @Override
    public Priority update(Priority obj) {
        return null;
    }

    @Override
    public Priority delete(int id) {
        return null;
    }
}
