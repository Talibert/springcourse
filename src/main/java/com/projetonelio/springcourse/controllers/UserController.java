package com.projetonelio.springcourse.controllers;

import com.projetonelio.springcourse.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController é uma anotação que combina @Controller com @ResponseBody. Sua função é retornar o objeto e não a view
 * @RequestMapping define o caminho da URL para chegar nos métodos
 */
@RestController
@RequestMapping (value = "/users")
public class UserController {

    /**
     * @GetMapping irá definir que solicitações do tipo Get que chegarem por essa URL irão cair nesse método
     * @return
     */
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "guilherme", "guilhermetaliberti@gmail.com", "telefone", "senha");
        return ResponseEntity.ok().body(u);
    }
}
