package com.spring.fundamentos.controller;

import com.spring.fundamentos.CaseUser.CreateUser;
import com.spring.fundamentos.CaseUser.DeleteUser;
import com.spring.fundamentos.CaseUser.GetUser;
import com.spring.fundamentos.CaseUser.UpdateUser;
import com.spring.fundamentos.entity.User;
import com.spring.fundamentos.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Con esta anotacion todos los metodos se formatean con el formato json
@RequestMapping("/api/users")
public class UserRestController {
    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private UserRepository userRepository;

    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser, UserRepository userRepository) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.userRepository = userRepository;
    }
    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
}
    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity deleUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.upDate(newUser, id), HttpStatus.OK);
    }
    @GetMapping("/pageable")
    List<User> getUserPageable(@RequestParam int page, @RequestParam int size){
        return userRepository.findAll(PageRequest.of(page,size)).getContent();
    }
}
