package com.trabajo.obesidad.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.obesidad.model.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
@CrossOrigin("*")
public class ControllerUsuario {
    
    @Autowired
    private IUsuarioController iCategoriaService;

    @GetMapping("/list")
    public ResponseEntity<List<UsuarioModel>> list(){
        var result = iCategoriaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody UsuarioModel c){
        ServiceResponse serv = new ServiceResponse();
        int result = iCategoriaService.save(c);
        if(result == 1){
            serv.setMessage("Item agregado");
        }
        return new ResponseEntity<>(serv, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody UsuarioModel c){
        ServiceResponse serv = new ServiceResponse();
        int result = iCategoriaService.update(c);
        if(result == 1){
            serv.setMessage("Item actualizado");
        }
        return new ResponseEntity<>(serv, HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serv = new ServiceResponse();
        int result = iCategoriaService.delete(id);
        if(result == 1){
            serv.setMessage("Item eliminado");
        }
        return new ResponseEntity<>(serv, HttpStatus.OK);
    }
}
