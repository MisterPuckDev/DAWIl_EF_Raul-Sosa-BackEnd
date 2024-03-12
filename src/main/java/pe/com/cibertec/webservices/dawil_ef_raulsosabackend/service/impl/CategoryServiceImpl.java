package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Category;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.repository.CategoryRepository;
import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @Override
    public Category serachById(int id) {
        return null;
    }

    @Override
    public Category add(Category obj) {
        return null;
    }

    @Override
    public Category update(Category obj) {
        return null;
    }

    @Override
    public Category delete(int id) {
        return null;
    }
}
