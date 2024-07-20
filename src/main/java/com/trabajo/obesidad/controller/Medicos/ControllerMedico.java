package com.trabajo.obesidad.controller.Medicos;

import java.util.List;

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

import com.trabajo.obesidad.model.ServiceResponse;
import com.trabajo.obesidad.model.Medicos.MedicosModel;

@RestController
@RequestMapping("api/v1/medicos")
@CrossOrigin("*")
public class ControllerMedico {
    @Autowired
    private IMedicoController iMedicosService;

    @GetMapping("/list")
    public ResponseEntity<List<MedicosModel>> list(){
        var result = iMedicosService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody MedicosModel c){
        ServiceResponse serv = new ServiceResponse();
        int result = iMedicosService.save(c);
        if(result == 1){
            serv.setMessage("Item agregado");
        }
        return new ResponseEntity<>(serv, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody MedicosModel c){
        ServiceResponse serv = new ServiceResponse();
        int result = iMedicosService.update(c);
        if(result == 1){
            serv.setMessage("Item actualizado");
        }
        return new ResponseEntity<>(serv, HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serv = new ServiceResponse();
        int result = iMedicosService.delete(id);
        if(result == 1){
            serv.setMessage("Item eliminado");
        }
        return new ResponseEntity<>(serv, HttpStatus.OK);
    }

    @GetMapping("/login/{nombre}/{pass}")
    public ResponseEntity<MedicosModel> login(@PathVariable String nombre, @PathVariable String pass){
        //ServiceResponse serv = new ServiceResponse();
        MedicosModel result = iMedicosService.login(nombre, pass);
        
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
