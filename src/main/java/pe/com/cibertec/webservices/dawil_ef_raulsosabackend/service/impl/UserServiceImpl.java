package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.User;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.projections.ReportUserForCategory;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.repository.UserRepository;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User serachById(int id) {
        return null;
    }

    @Override
    public List<ReportUserForCategory> getReport(int id) {
        List<Object[]> listReport = userRepository.getReportUserForCategory(id);
        List<ReportUserForCategory> finalList = new ArrayList<>();
        for (Object[] row : listReport) {
            Integer idReporte = (Integer) row[0];
            String username = (String) row[1];
            String name = (String) row[2];
            String lastUName = (String) row[3];
            String email = (String) row[4];
            String password = (String) row[5];
            Integer state = (Integer) row[6];
            Integer kind = (Integer) row[7];
            ReportUserForCategory reportObj = new ReportUserForCategory(idReporte, username, name, lastUName, email, password, state, kind);
            finalList.add(reportObj);
        }
        return finalList;
    }

    @Override
    public User add(User obj) {
        return userRepository.save(obj);
    }

    @Override
    public User update(User obj) {
        return userRepository.save(obj);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
