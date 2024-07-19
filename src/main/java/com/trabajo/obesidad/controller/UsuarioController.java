package com.trabajo.obesidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabajo.obesidad.model.UsuarioModel;
import com.trabajo.obesidad.repository.IObesidadRepository;

import java.util.List;

@Service
public class UsuarioController implements IUsuarioController{

    @Autowired
    private IObesidadRepository iCategoriaRepository;

    @Override
    public List<UsuarioModel> findAll() {
        List<UsuarioModel> list = null;
        try{
            list = iCategoriaRepository.findAll();
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public int save(UsuarioModel pr) {
        int row;
        try{
            row = iCategoriaRepository.save(pr);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update(UsuarioModel pr) {
        int row;
        try{
            row = iCategoriaRepository.update(pr);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int delete(int id) {
        int row;
        try{
            row = iCategoriaRepository.delete(id);
        }catch (Exception e){
            throw e;
        }
        return row;
    }
}
