package pe.com.cibertec.webservices.dawil_ef_raulsosabackend.service;

import pe.com.cibertec.webservices.dawil_ef_raulsosabackend.model.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> list();

    public Category serachById(int id);

    public Category add(Category obj);

    public Category update(Category obj);

    public Category delete(int id);

}
