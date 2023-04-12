package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;


@Service // registra um serviço nasua camada de servio 
public class UserService {
    @Autowired //injeção de dependências 
    private UserRepository repository;

    //metodo para retonar todos os usuario do banco / endpoint get que retorna todos os id
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}
