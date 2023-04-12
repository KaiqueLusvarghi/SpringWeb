package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service // registra um serviço nasua camada de servio
public class CategoryService {
    @Autowired // injeção de dependências
    private CategoryRepository repository;

    // metodo para retonar todos os usuario do banco / endpoint get que retorna
    // todos os id
    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
