package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")  //endpoint (API)
public class UserResource {
  
    @Autowired  // o Spring faz a injeção das dependências 
    private UserService service;

    //controlador Rest
    @GetMapping
    public ResponseEntity<List<User>> findAll(){  // GET que retonar todos os id

        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
    @GetMapping (value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    

}
