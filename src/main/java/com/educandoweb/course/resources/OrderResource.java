package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;

import com.educandoweb.course.services.OrderService;


@RestController
@RequestMapping(value = "/orders")  //endpoint (API)
public class OrderResource {
  
    @Autowired  // o Spring faz a injeção das dependências 
    private OrderService service;

    //controlador Rest
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){  // GET que retonar todos os id

        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
    @GetMapping (value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    

}
