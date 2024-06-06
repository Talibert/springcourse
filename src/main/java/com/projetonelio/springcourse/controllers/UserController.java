package com.projetonelio.springcourse.controllers;

import com.projetonelio.springcourse.entities.User;
import com.projetonelio.springcourse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @RestController é uma anotação que combina @Controller com @ResponseBody. Sua função é retornar o objeto e não a view
 * @RequestMapping define o caminho da URL para chegar nos métodos
 */
@RestController
@RequestMapping (value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @GetMapping irá definir que solicitações do tipo Get que chegarem por essa URL irão cair nesse método
     * @return
     */
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> userList = userService.findAll();

        return ResponseEntity.ok().body(userList);
    }

    /**
     * @PathVariable diz que o parâmetro que o método recebe virá através da URL. Dessa forma associa o id da URL com o
     * id do parâmetro
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);

        return ResponseEntity.ok().body(user);
    }
}
