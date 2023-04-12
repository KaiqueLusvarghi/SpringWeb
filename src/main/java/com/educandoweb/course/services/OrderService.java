package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;



@Service // registra um serviço nasua camada de servio 
public class OrderService {
    @Autowired //injeção de dependências 
    private OrderRepository repository;

    //metodo para retonar todos os usuario do banco / endpoint get que retorna todos os id
    public List<Order> findAll(){
       // return repository.findAll();
       return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
